package com.gymme.domain.handlers

import com.gymme.domain.entities.Metrics
import com.gymme.domain.entities.User
import com.gymme.domain.repositories.IMetricsRepository
import com.gymme.domain.repositories.IUserRepository

class UserHandler(private val repository: IUserRepository) {
    suspend fun execute(login: String, password: String): User {
        return repository.getUser(login, password)
    }
}