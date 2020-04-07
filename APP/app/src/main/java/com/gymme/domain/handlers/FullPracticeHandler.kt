package com.gymme.domain.handlers

import com.gymme.domain.entities.Exercise
import com.gymme.domain.repositories.IWorksheetExercisesRepository

class FullPracticeHandler(private val PracticeRepository: IPracticeRepositoryRepository) {
    suspend fun execute(practiceId: Int): List<Exercise> {

        return repository.getWorksheetExercises(worksheetId)
    }
}
