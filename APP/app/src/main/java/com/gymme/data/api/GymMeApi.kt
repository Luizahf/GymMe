package com.gymme.data.api

import com.gymme.data.data.GetWorksheetExercisesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GymMeApi {
    @GET("worksheetExercises/{worksheetId}/exercises")
    fun getWorksheetExercises(@Path("worksheetId") worksheetId: Int): Call<GetWorksheetExercisesResponse>
}