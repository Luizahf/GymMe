package com.gymme.domain.repositories

import com.gymme.domain.Responses.InsertUser
import com.gymme.domain.entities.User

interface IUserRepository {
    suspend fun getUser(login: String, password: String) : User
    suspend fun insertUser(login: String, password: String) : InsertUser
}