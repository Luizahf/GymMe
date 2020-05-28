package com.gymme.domain.handlers
import com.gymme.domain.entities.Practice
import com.gymme.domain.repositories.IPracticeRepository

class FullPracticeHandler(private val PracticeRepository: IPracticeRepository) {
    suspend fun execute(userId: Int): List<Practice> {

        return PracticeRepository.getPractices(userId)
    }
}
