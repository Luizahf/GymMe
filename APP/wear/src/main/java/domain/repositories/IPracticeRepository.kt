package com.gymme.domain.repositories

import com.gymme.domain.entities.Practice

interface IPracticeRepository {
    suspend fun getPractices(idUser: Int) : List<Practice>
}