package com.gymme.data.data

import com.gymme.domain.entities.User

interface InsertUserResponse {
    fun failure(statusCode: Int?, message: String)
    fun success(user: User)
}