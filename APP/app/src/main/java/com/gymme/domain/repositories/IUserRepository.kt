package com.gymme.domain.repositories

import com.gymme.data.data.InsertUserResponse
import com.gymme.domain.entities.User

interface IUserRepository {
    suspend fun getUser(login: String, password: String) : User
    suspend fun insertUser(insertUserResponse: InsertUserResponse, name: String, height: Int?, weight: Int?, loginId: Int) : User
}


        