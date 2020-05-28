package com.gymme.app.ui.StartExercises

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.entities.CompleteExercise
import com.gymme.domain.handlers.MetricsHandler
import com.gymme.domain.handlers.WorksheetExercisesHandler

class StartExercisesViewModel (application: Application,
                               private val worksheetExercisesHandler: WorksheetExercisesHandler,
                               private val metricsHandler: MetricsHandler) : ViewModelBase(application) {
    var exercisesList = MutableLiveData<List<CompleteExercise>>().apply {value = null}

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
}