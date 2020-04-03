package com.gymme.domain.repositories

import com.gymme.data.data.Base.ExerciseEntity
import com.gymme.domain.entities.Exercise

interface IWorksheetExercisesRepository {
    suspend fun getWorksheetExercises(worksheetId: Int) : List<Exercise>
}