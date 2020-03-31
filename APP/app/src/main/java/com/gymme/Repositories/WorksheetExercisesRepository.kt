package com.raywenderlich.gymme.Repositories

import com.raywenderlich.gymme.Features.DataAccessObjects.WorksheetExercisesDao
import com.raywenderlich.gymme.Services.dto.WorksheetExercise
class WorksheetExercisesRepository private constructor(
        private val worksheetExercisesDao: WorksheetExercisesDao
) {
    fun insert(worksheetExercises: Array<String>) {
        worksheetExercisesDao.insert(worksheetExercises)
    }
}