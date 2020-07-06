package com.gymme.domain.repositories

import com.gymme.data.data.Base.ExerciseEntity
import com.gymme.data.data.InsertWorksheetExercisesResponse
import com.gymme.domain.entities.Exercise
import com.gymme.domain.entities.Worksheet

interface IWorksheetExercisesRepository {
    suspend fun getWorksheetExercises(worksheetId: Int) : List<Exercise>
    suspend fun insertWorksheetExercises(insertWorksheetExercisesResponse: InsertWorksheetExercisesResponse, name: String, practiceId: Int, exerciseList: List<Exercise>) : Worksheet
}