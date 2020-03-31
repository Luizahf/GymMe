package com.raywenderlich.gymme.Services.Responses

import com.raywenderlich.gymme.Services.Responses.Base.FaliureResponse
import com.raywenderlich.gymme.Services.dto.WorksheetExercise

interface GetWorksheetExercisesResponse : FaliureResponse {
    fun success(worksheetExercises: Array<String>?)
}