package com.gymme.domain.handlers

import com.gymme.domain.entities.Worksheet
import com.gymme.domain.repositories.IPracticeWorksheetseRepository

class PracticeWorksheetsHandler(private val repository: IPracticeWorksheetseRepository) {
    suspend fun execute(practiceId: Int): List<Worksheet> {
        return repository.getPracticeWorksheets(practiceId)
    }
}