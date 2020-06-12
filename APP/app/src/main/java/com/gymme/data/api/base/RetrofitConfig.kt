package com.gymme.data.api.base

import com.google.gson.GsonBuilder
import com.gymme.data.api.GymMeApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
    var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    fun<s> createService(serviceClass: Class<s>): s {
        return retrofit.create(serviceClass)
    }
}