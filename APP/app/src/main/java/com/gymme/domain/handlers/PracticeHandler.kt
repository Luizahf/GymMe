package com.gymme.domain.handlers

import com.gymme.data.data.InsertPracticeResponse
import com.gymme.domain.entities.Practice
import com.gymme.domain.repositories.IPracticeRepository

class PracticeHandler(private val repository: IPracticeRepository) {
    suspend fun execute(idUser: Int): List<Practice> {
        return repository.getPractices(idUser)
    }

    suspend fun executeInsertPractice(insertUserResponse: InsertPracticeResponse, description: String, goal: String?, frequency: Int?, userId: Int) {
        return repository.insertPractice(insertUserResponse, description, goal, frequency, userId)
    }
}