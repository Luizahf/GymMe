package com.gymme.domain.repositories

import com.gymme.domain.entities.Practice

interface IPracticeRepository {
    suspend fun getUserPractices(idUser: Int) : List<Practice>
}