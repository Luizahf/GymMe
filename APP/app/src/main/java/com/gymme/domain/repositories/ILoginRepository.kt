package com.gymme.domain.repositories

import com.gymme.domain.entities.Login

interface ILoginRepository {
    suspend fun insertLogin(login: String, password: String) : Login
}