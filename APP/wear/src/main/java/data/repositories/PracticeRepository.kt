package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.data.Base.PracticeEntity
import com.gymme.domain.entities.Practice
import com.gymme.domain.repositories.IPracticeRepository

class PracticeRepository(
        private val api: GymMeApi) : IPracticeRepository {
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