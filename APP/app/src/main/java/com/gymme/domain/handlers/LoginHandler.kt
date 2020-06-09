package com.gymme.domain.handlers

import com.gymme.domain.entities.Login
import com.gymme.domain.repositories.ILoginRepository

class LoginHandler(private val repository: ILoginRepository) {
    suspend fun executeInsertLogin(login: String, password: String): Login {
        return repository.insertLogin(login, password)
    }
}