package com.gymme.data.data

import com.gymme.domain.entities.Login

interface InsertLoginResponse {
    fun failure(statusCode: Int?, message: String)
    fun success(login: Login)
}