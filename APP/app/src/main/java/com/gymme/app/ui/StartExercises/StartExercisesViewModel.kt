package com.gymme.app.ui.StartExercises

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.data.data.Base.MetricsEntity
import com.gymme.data.data.InsertExerciseMetricsResponse
import com.gymme.domain.entities.*
import com.gymme.domain.handlers.MetricsHandler
import com.gymme.domain.handlers.PracticeHandler
import com.gymme.domain.handlers.PracticeWorksheetsHandler
import com.gymme.domain.handlers.WorksheetExercisesHandler
import java.util.ArrayList

class StartExercisesViewModel(application: Application,
                              private val worksheetExercisesHandler: WorksheetExercisesHandler,
                              private val practiceHandler: PracticeHandler,
                              private val practiceWorksheetsHandler: PracticeWorksheetsHandler,
                              private val metricsHandler: MetricsHandler) : ViewModelBase(application) {

    var exercisesList = MutableLiveData<List<CompleteExercise>>().apply {value = null}
    var practiceList = MutableLiveData<List<Practice>>().apply {value = null}
    var worksheetList = MutableLiveData<List<Worksheet>>().apply {value = null}
    var insertedMetrics = MutableLiveData<WorksheetExerciseMetrics>().apply {value = null}
    var errorMessage = MutableLiveData<String>().apply {value = null}

    fun getPractices(userId: Int) {
        doAsyncWork {
            val resultList = practiceHandler.execute(userId)
            practiceList.postValue(resultList)
        }
    }

    fun getPracticeWorksheets(practiceId: Int) {
        doAsyncWork {
            val resultList = practiceWorksheetsHandler.execute(practiceId)
            worksheetList.postValue(resultList)
        }
    }

    fun getWorksheetExercises(worksheetId: Int) {
        val resultList = mutableListOf<CompleteExercise>()
        doAsyncWork {
            val exerciseList = worksheetExercisesHandler.execute(worksheetId)
            exerciseList.forEach { exercise ->
                val metrics = metricsHandler.execute(worksheetId, exercise.id)
                resultList.add(CompleteExercise(exercise, metrics))
            }
            exercisesList.postValue(resultList)
        }
    }

    fun selectPractice(practice: String) {
        val practiceId = practiceList.value!!.filter { pract -> pract.description == practice }[0].id
        getPracticeWorksheets(practiceId)
    }

    fun selectWorksheet(worksheet: String) {
        val worksheetId = worksheetList.value!!.filter { wrksht -> wrksht.description == worksheet }[0].id
        getWorksheetExercises(worksheetId)
    }

    fun insertExerciseMetrics(exerciseId: Int, worksheetId: Int, metrics: MetricsEntity) {
        doAsyncWork {
            metricsHandler.executeInsertExerciseMetrics(object: InsertExerciseMetricsResponse {
                override fun success(insertedWorksheetExerciseMetrics: WorksheetExerciseMetrics) {
                    insertedMetrics.postValue(insertedWorksheetExerciseMetrics)
                }

                override fun failure(statusCode: Int?, message: String) {
                    errorMessage.postValue(message)
                }
            }, exerciseId, worksheetId, metrics)
        }
    }
}
