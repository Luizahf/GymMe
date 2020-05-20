package com.gymme.domain.repositories

import com.gymme.domain.entities.User

interface IUserRepository {
    suspend fun getUser(userId: Int) : User
}