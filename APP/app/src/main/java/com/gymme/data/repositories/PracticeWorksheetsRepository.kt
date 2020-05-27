package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.data.Base.WorksheetEntity
import com.gymme.domain.entities.Worksheet
import com.gymme.domain.repositories.IPracticeWorksheetseRepository

class PracticeWorksheetsRepository(
        private val api: GymMeApi) : IPracticeWorksheetseRepository {
    override suspend fun getPracticeWorksheets(idUser: Int): List<Worksheet> {
        try {
            val response: List<WorksheetEntity>? = api.getPracticeWorksheets(idUser)!!.execute().body()
            val result = mutableListOf<Worksheet>()

            if (response != null && !response.isEmpty())
            {
                response.forEach { worksheet ->
                    result.add(
                            Worksheet(
                                    id = worksheet!!.id,
                                    description = worksheet!!.description,
                                    practiceId = worksheet!!.practiceId)
                    )
                }
                return result
            }
            else {
                result.add(result.last())
                return result
            }
        }
        catch(e: Exception) {
            val message = "Falha ao obter fichas do treino."
            throw Exception(message)
        }
    }
}