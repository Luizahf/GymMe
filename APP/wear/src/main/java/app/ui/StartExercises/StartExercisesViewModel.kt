package com.gymme.app.ui.StartExercises

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.data.data.Base.MetricsEntity
import com.gymme.data.data.InsertExerciseMetricsResponse
import com.gymme.domain.entities.CompleteExercise
import com.gymme.domain.entities.WorksheetExerciseMetrics
import com.gymme.domain.handlers.MetricsHandler
import com.gymme.domain.handlers.WorksheetExercisesHandler

class StartExercisesViewModel (application: Application,
                               private val worksheetExercisesHandler: WorksheetExercisesHandler,
                               private val metricsHandler: MetricsHandler) : ViewModelBase(application) {
    var exercisesList = MutableLiveData<List<CompleteExercise>>().apply {value = null}
    var insertedMetrics = MutableLiveData<WorksheetExerciseMetrics>().apply {value = null}
    var errorMessage = MutableLiveData<String>().apply {value = null}

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