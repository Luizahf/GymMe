package com.raywenderlich.gymme.Services

import com.raywenderlich.gymme.Services.dto.WorksheetExercises
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory





public class RetrofitConfig {
    var retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:5000/api/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

    fun getWorksheetExercises() : GymMeRest {
        return retrofit.create(GymMeRest::class.java)
    }
}