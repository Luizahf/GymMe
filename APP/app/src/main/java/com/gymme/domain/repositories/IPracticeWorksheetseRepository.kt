package com.gymme.domain.repositories

import com.gymme.domain.entities.Practice
import com.gymme.domain.entities.Worksheet

interface IPracticeWorksheetseRepository {
    suspend fun getPracticeWorksheets(practiceId: Int) : List<Worksheet>
}