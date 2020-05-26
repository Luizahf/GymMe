package com.gymme.data.api

import com.gymme.data.data.Base.ExerciseEntity
import com.gymme.data.data.Base.MetricsEntity
import data.data.Base.UserEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GymMeApi {
    @GET("worksheetExercises/{worksheetId}/exercises")
    fun getWorksheetExercises(@Path("worksheetId") worksheetId: Int): Call<List<ExerciseEntity>?>

    @GET("metrics/{worksheetId}/exercise/{exerciseId}")
    fun getMetrics(@Path("worksheetId") worksheetId: Int, exerciseId: Int): Call<MetricsEntity>?

    @GET("users/{login}/{password}")
    fun getUser(@Path("login") login: String, password: String) : Call<UserEntity>?
}
