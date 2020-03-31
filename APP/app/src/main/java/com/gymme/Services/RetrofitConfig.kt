package com.raywenderlich.gymme.Services

import com.google.gson.GsonBuilder
import com.raywenderlich.gymme.Services.dto.WorksheetExercise
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





public class RetrofitConfig {
    val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
    var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    fun getWorksheetExercises() : GymMeRest {
        return retrofit.create(GymMeRest::class.java)
    }
}