package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.dao.WorksheetExercisesDao
import com.gymme.data.data.Base.ExerciseEntity
import com.gymme.data.data.Base.InsertWorksheetExercisesRequest
import com.gymme.data.data.Base.WorksheetEntity
import com.gymme.data.data.InsertWorksheetExercisesResponse
import com.gymme.data.data.LocalExercise
import com.gymme.domain.entities.Exercise
import com.gymme.domain.entities.Worksheet
import com.gymme.domain.repositories.IWorksheetExercisesRepository
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class WorksheetExercisesRepository (
        private val dao: WorksheetExercisesDao,
        private val api: GymMeApi
) : IWorksheetExercisesRepository {
    override suspend fun insertWorksheetExercises(insertWorksheetExercisesResponse: InsertWorksheetExercisesResponse, name: String, practiceId: Int, exerciseList: List<Exercise>): Worksheet {
        val call = api.insertWorksheetExercises(InsertWorksheetExercisesRequest(Worksheet(0, name, practiceId), exerciseList))

        call!!.enqueue(object: Callback<WorksheetEntity?> {
            override fun onFailure(call: Call<WorksheetEntity?>, t: Throwable) {
            }

            override fun onResponse(call: Call<WorksheetEntity?>, response: Response<WorksheetEntity?>) {
                if (response?.code() == 400) {
                    val jObjError = JSONArray(response.errorBody()!!.string())
                    insertWorksheetExercisesResponse.failure(400, jObjError.getString(0))
                } else if (response.isSuccessful) {
                    val insertedLogin : WorksheetEntity? = response.body()
                    insertWorksheetExercisesResponse.success(Worksheet(
                            id = insertedLogin!!.id,
                            description = insertedLogin.description,
                            practiceId = insertedLogin.practiceId))
                }
            }
        })

        return Worksheet(0,"", 0)
    }

    override suspend fun getWorksheetExercises(worksheetId: Int): List<Exercise> {
        try {
            val response: List<ExerciseEntity>? =
                    api.getWorksheetExercises(worksheetId).execute().body()

            return response?.map { Exercise(
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