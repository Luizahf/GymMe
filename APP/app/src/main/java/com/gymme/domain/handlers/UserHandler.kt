package com.gymme.domain.handlers

import com.gymme.domain.Responses.InsertUser
import com.gymme.domain.entities.User
import com.gymme.domain.repositories.IUserRepository

class UserHandler(private val repository: IUserRepository) {
    suspend fun executeGetUser(login: String, password: String): User {
        return repository.getUser(login, password)
    }

    suspend fun executeInsertUser(name: String, height: Int?, weight: Int?, loginId: Int): InsertUser {
        return repository.insertUser(name, height, weight, loginId)
    }
}