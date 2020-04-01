package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.dao.WorksheetExercisesDao
import com.gymme.data.data.GetWorksheetExercisesResponse
import com.gymme.data.data.LocalExercise
import com.gymme.domain.entities.Exercise
import com.gymme.domain.repositories.IWorksheetExercisesRepository
import java.lang.Exception

class WorksheetExercisesRepository (
        private val dao: WorksheetExercisesDao,
        private val api: GymMeApi
) : IWorksheetExercisesRepository {

    override suspend fun getWorksheetExercises(worksheetId: Int): List<Exercise> {
        try {
            val response: GetWorksheetExercisesResponse? =
                    api.getWorksheetExercises(worksheetId).execute().body()

            return response?.worksheetExercises?.map { Exercise(
                    description = it.description,
                    id = it.id!!
            )} ?: listOf()
        }
        catch(e: Exception) {
            val message = "Falha ao obter os exercícios da ficha."
            throw Exception(message)
        }
    }

    suspend fun insert(worksheetLocalExercises: List<LocalExercise>) {
        dao.insert(worksheetLocalExercises)
    }
}