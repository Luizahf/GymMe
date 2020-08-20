package com.gymme.app.ui.MyWorksheet

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gymme.app.ViewModelBase
import com.gymme.data.repositories.WorksheetExercisesRepository
import com.gymme.data.data.LocalExercise
import com.gymme.domain.entities.CompleteExercise
import com.gymme.domain.entities.CompleteWorksheet
import com.gymme.domain.entities.Practice
import com.gymme.domain.entities.Worksheet
import com.gymme.domain.handlers.MetricsHandler
import com.gymme.domain.handlers.PracticeHandler
import com.gymme.domain.handlers.PracticeWorksheetsHandler
import com.gymme.domain.handlers.WorksheetExercisesHandler

class MyWorksheetViewModel internal constructor(
        application: Application,
        private val worksheetExercisesRepository: WorksheetExercisesRepository,
        private val worksheetExercisesHandler: WorksheetExercisesHandler,
        private val practiceWorksheetsHandler: PracticeWorksheetsHandler,
        private val practiceHandler: PracticeHandler,
        private val metricsHandler: MetricsHandler
) : ViewModelBase(application) {

    var exercisesList = MutableLiveData<List<CompleteWorksheet>>().apply {value = null}
    var practiceList = MutableLiveData<List<Practice>>().apply {value = null}
    var worksheetList = MutableLiveData<List<Worksheet>>().apply {value = null}

    fun getWorksheetExercises(worksheetsIds: List<Worksheet>) {
        val list: MutableList<CompleteWorksheet> = mutableListOf<CompleteWorksheet>()
        worksheetsIds.forEach { wrkst ->
            val resultList = mutableListOf<CompleteExercise>()
            doAsyncWork {
                val exerciseList = worksheetExercisesHandler.execute(wrkst.id)
                exerciseList.forEach { exercise ->
                    val metrics = metricsHandler.execute(wrkst.id, exercise.id)
                    resultList.add(CompleteExercise(exercise, metrics))
                }
                list.add(CompleteWorksheet(resultList, wrkst.description))
                if(worksheetsIds.indexOf(wrkst) == (worksheetsIds.size-1)) {
                    exercisesList.postValue(list)
                }
            }
        }

    }

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
}