package com.gymme.domain.repositories

import com.gymme.data.data.InsertLoginResponse
import com.gymme.domain.entities.Login

interface ILoginRepository {
    suspend fun insertLogin(insertLoginResponse: InsertLoginResponse, login: String, password: String) : Login
}