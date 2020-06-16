package com.gymme.domain.repositories

import com.gymme.data.data.InsertPracticeResponse
import com.gymme.domain.entities.Practice

interface IPracticeRepository {
    suspend fun getPractices(idUser: Int) : List<Practice>
    suspend fun insertPractice(insertPracticeResponse: InsertPracticeResponse, description: String, goal: String?, frequency: Int?, userId: Int)
}
