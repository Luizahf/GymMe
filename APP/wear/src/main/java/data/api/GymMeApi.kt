package com.gymme.data.api

import com.gymme.data.data.Base.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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
    fun getPractice(@Path("userId") userId: Int) : Call<List<PracticeEntity>>?

    @GET("practiceWorksheets/{practiceId}/worksheets")
    fun getPracticeWorksheets(@Path("practiceId") practiceId: Int) : Call<List<WorksheetEntity>>?

    @POST("metrics/insert")
    fun insertExerciseMetrics(@Body newExerciseMetrics: InsertWorksheetExerciseMetricsRequest) : Call<WorksheetExerciseMetricsEntity>?
}
