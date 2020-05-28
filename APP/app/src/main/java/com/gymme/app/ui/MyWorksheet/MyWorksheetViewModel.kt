package com.gymme.app.ui.MyWorksheet

import android.app.Application
import androidx.lifecycle.ViewModel
import com.gymme.app.ViewModelBase
import com.gymme.data.repositories.WorksheetExercisesRepository
import com.gymme.data.data.LocalExercise

class MyWorksheetViewModel internal constructor(
        application: Application,
        private val worksheetExercisesRepository: WorksheetExercisesRepository
) : ViewModelBase(application) {

    fun storeWorksheetWorkouts(worksheetLocalExercises: List<LocalExercise>) {
        doAsyncWork {
            worksheetExercisesRepository.insert(worksheetLocalExercises)
        }
    }
}