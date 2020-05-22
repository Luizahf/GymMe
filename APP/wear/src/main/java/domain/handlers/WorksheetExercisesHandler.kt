package com.gymme.domain.handlers

import com.gymme.domain.entities.Exercise
import com.gymme.domain.repositories.IWorksheetExercisesRepository

class WorksheetExercisesHandler(private val repository: IWorksheetExercisesRepository) {
    suspend fun execute(worksheetId: Int): List<Exercise> {
        return repository.getWorksheetExercises(worksheetId)
    }
}