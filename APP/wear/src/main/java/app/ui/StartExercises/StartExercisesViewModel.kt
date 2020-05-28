package com.gymme.app.ui.StartExercises

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.entities.Exercise
import com.gymme.domain.handlers.WorksheetExercisesHandler

class StartExercisesViewModel (application: Application,
                               private val worksheetExercisesHandler: WorksheetExercisesHandler) : ViewModelBase(application) {
    var worksheetExercisesList = MutableLiveData<List<Exercise>>().apply {value = null}

    fun getWorksheetExercises(worksheetId: Int) {
        doAsyncWork {
            val resultList = worksheetExercisesHandler.execute(worksheetId)
            worksheetExercisesList.postValue(resultList)
        }
    }
}