package com.gymme.data.data

import com.gymme.domain.entities.Worksheet

interface InsertWorksheetExercisesResponse {
    fun failure(statusCode: Int?, message: String)
    fun success(worksheet: Worksheet)
}