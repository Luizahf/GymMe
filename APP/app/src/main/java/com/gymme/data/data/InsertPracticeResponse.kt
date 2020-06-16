package com.gymme.data.data

import com.gymme.domain.entities.Practice

interface InsertPracticeResponse {
    fun failure(statusCode: Int?, message: String)
    fun success(user: Practice)
}