package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.data.Base.InsertPracticeRequest
import com.gymme.data.data.Base.PracticeEntity
import com.gymme.data.data.InsertPracticeResponse
import com.gymme.domain.entities.Practice
import com.gymme.domain.repositories.IPracticeRepository
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PracticeRepository(
        private val api: GymMeApi) : IPracticeRepository {
    override suspend fun insertPractice(insertPracticeResponse: InsertPracticeResponse, description: String, goal: String?, frequency: Int?, userId: Int){
        val call = api.insertPractice(InsertPracticeRequest(description, goal, null, frequency, userId))

        call!!.enqueue(object: Callback<PracticeEntity?> {
            override fun onFailure(call: Call<PracticeEntity?>, t: Throwable) {
            }

            override fun onResponse(call: Call<PracticeEntity?>, response: Response<PracticeEntity?>) {
                if (response?.code() == 400) {
                    val jObjError = JSONArray(response.errorBody()!!.string())
                    insertPracticeResponse.failure(400, jObjError.getString(0))
                } else if (response.isSuccessful) {
                    val insertedPractice : PracticeEntity? = response.body()
                    insertPracticeResponse.success(Practice(
                            id = insertedPractice!!.id,
                            description = insertedPractice.description,
                            goal = insertedPractice.goal,
                            dueDate = insertedPractice.dueDate,
                            frequency = insertedPractice.frequency,
                            userId = insertedPractice.userId))
                }
            }
        })
    }

    override suspend fun getPractices(idUser: Int): List<Practice> {
        try {
            val response: List<PracticeEntity>? = api.getPractice(idUser)!!.execute().body()
            val result = mutableListOf<Practice>()

            if (response != null && !response.isEmpty())
            {
                response.forEach { practice ->
                    result.add(
                        Practice(
                            id = practice!!.id,
                            description = practice!!.description,
                            goal = practice!!.goal,
                            dueDate = practice!!.dueDate,
                            frequency = practice!!.frequency,
                            userId = practice!!.userId)
                    )
                }
                return result
            }
            else {
                result.add(Practice(0,"",null,null, null,0))
                return result
            }
        }
        catch(e: Exception) {
            val message = "Falha ao obter treino."
            throw Exception(message)
        }
    }
}