package com.gymme.domain.handlers

import com.gymme.data.data.InsertUserResponse
import com.gymme.domain.entities.User
import com.gymme.domain.repositories.IUserRepository

class UserHandler(private val repository: IUserRepository) {
    suspend fun executeGetUser(login: String, password: String): User {
        return repository.getUser(login, password)
    }

    suspend fun executeInsertUser(insertUserResponse: InsertUserResponse, name: String, height: Int?, weight: Int?, loginId: Int): User {
        return repository.insertUser(insertUserResponse, name, height, weight, loginId)
    }
}