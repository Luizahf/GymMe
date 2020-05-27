package com.gymme.app.ui.StartExercises

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.entities.Exercise
import com.gymme.domain.entities.Practice
import com.gymme.domain.entities.Worksheet
import com.gymme.domain.handlers.PracticeHandler
import com.gymme.domain.handlers.PracticeWorksheetsHandler
import com.gymme.domain.handlers.WorksheetExercisesHandler

class StartExercisesViewModel(application: Application,
                              private val worksheetExercisesHandler: WorksheetExercisesHandler,
                              private val practiceHandler: PracticeHandler,
                              private val practiceWorksheetsHandler: PracticeWorksheetsHandler) : ViewModelBase(application) {

    var worksheetExercisesList = MutableLiveData<List<Exercise>>().apply {value = null}
    var practiceList = MutableLiveData<List<Practice>>().apply {value = null}
    var worksheetList = MutableLiveData<List<Worksheet>>().apply {value = null}

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
        doAsyncWork {
            val resultList = worksheetExercisesHandler.execute(worksheetId)
            worksheetExercisesList.postValue(resultList)
        }
    }
}
