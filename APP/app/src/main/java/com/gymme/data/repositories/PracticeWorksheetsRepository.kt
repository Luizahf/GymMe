package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.domain.entities.Worksheet
import com.gymme.domain.repositories.IPracticeWorksheetseRepository

class PracticeWorksheetsRepository(
        private val api: GymMeApi) : IPracticeWorksheetseRepository {
    override suspend fun getPracticeWorksheets(idUser: Int): List<Worksheet> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}