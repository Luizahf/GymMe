package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.domain.entities.Practice
import com.gymme.domain.repositories.IPracticeRepository

class PracticeRepository(
        private val api: GymMeApi) : IPracticeRepository {
    override suspend fun getPractices(idUser: Int): List<Practice> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}