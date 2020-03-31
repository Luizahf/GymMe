package com.raywenderlich.gymme.Features.MyWorksheet

import android.arch.lifecycle.ViewModel
import com.raywenderlich.gymme.Repositories.WorksheetExercisesRepository
import com.raywenderlich.gymme.Services.dto.WorksheetExercise

class MyWorksheetViewModel internal constructor(
        private val worksheetExercisesRepository: WorksheetExercisesRepository
        ) : ViewModel() {

        fun storeWorksheetWorkouts(worksheetExercises: Array<String>) {
                worksheetExercisesRepository.insert(worksheetExercises)
        }
}