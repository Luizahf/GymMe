package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.data.Base.ExerciseEntity
import com.gymme.domain.entities.Exercise
import com.gymme.domain.entities.Practice
import com.gymme.domain.repositories.IPracticeRepository
import java.lang.Exception

class PracticeRepository(
        private val api: GymMeApi) : IPracticeRepository {
    override suspend fun getUserPractices(idUser: Int): List<Practice> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}