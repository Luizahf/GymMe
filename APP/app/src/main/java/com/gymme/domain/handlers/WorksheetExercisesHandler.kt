package com.gymme.domain.handlers

import com.gymme.data.data.InsertWorksheetExercisesResponse
import com.gymme.domain.entities.Exercise
import com.gymme.domain.entities.Worksheet
import com.gymme.domain.repositories.IWorksheetExercisesRepository

class WorksheetExercisesHandler(private val repository: IWorksheetExercisesRepository) {
    suspend fun execute(worksheetId: Int): List<Exercise> {
        return repository.getWorksheetExercises(worksheetId)
    }

    suspend fun executeinsertWorksheetExercises(insertWorksheetExercisesResponse: InsertWorksheetExercisesResponse, name: String, practiceId: Int, exerciseList: List<Exercise>): Worksheet {
        return repository.insertWorksheetExercises(insertWorksheetExercisesResponse, name, practiceId, exerciseList)
    }
}