package com.gymme.domain.handlers

import com.gymme.data.data.InsertLoginResponse
import com.gymme.domain.entities.Login
import com.gymme.domain.repositories.ILoginRepository

class LoginHandler(private val repository: ILoginRepository) {
    suspend fun executeInsertLogin(insertLoginResponse: InsertLoginResponse, login: String, password: String): Login {
        return repository.insertLogin(insertLoginResponse, login, password)
    }
}