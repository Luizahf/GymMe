package com.gymme.domain.handlers

import com.gymme.domain.entities.Worksheet
import com.gymme.domain.repositories.IPracticeWorksheetseRepository

class PracticeWorksheetsHandler(private val repository: IPracticeWorksheetseRepository) {
    suspend fun execute(userId: Int): List<Worksheet> {
        return repository.getPracticeWorksheets(userId)
    }
}