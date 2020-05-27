package com.gymme.data.api

import com.gymme.data.data.Base.*
import com.gymme.domain.entities.Exercise
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GymMeApi {
    @GET("worksheetExercises/{worksheetId}/exercises")
    fun getWorksheetExercises(@Path("worksheetId") worksheetId: Int): Call<List<ExerciseEntity>?>

    @GET("metrics/{worksheetId}/exercise/{exerciseId}")
    fun getMetrics(@Path("worksheetId") worksheetId: Int,
                   @Path("exerciseId") exerciseId: Int): Call<MetricsEntity>?

    @GET("users/{login}/{password}")
    fun getUser(@Path("login") login: String,
                @Path("password") password: String) : Call<UserEntity>?

    @GET("practice/{userId}")
    fun getPractice(@Path("userId") userId: Int) : Call<PracticeEntity>?

    @GET("practiceWorksheets/{practiceId}/worksheets")
    fun getPracticeWorksheets(@Path("practiceId") practiceId: Int) : Call<List<WorksheetEntity>>?
}
