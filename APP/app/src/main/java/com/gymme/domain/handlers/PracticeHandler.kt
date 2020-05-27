package com.gymme.domain.handlers

import com.gymme.domain.entities.Practice
import com.gymme.domain.repositories.IPracticeRepository

class PracticeHandler(private val repository: IPracticeRepository) {
    suspend fun execute(practiceId: Int): List<Practice> {
        return repository.getPractices(practiceId)
    }
}