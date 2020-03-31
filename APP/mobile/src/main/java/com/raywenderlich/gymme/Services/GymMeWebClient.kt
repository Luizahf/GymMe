package com.raywenderlich.gymme.Services

import android.os.AsyncTask
import android.util.Log
import com.raywenderlich.gymme.Services.Responses.GetWorksheetExercisesResponse
import com.raywenderlich.gymme.Services.dto.WorksheetExercise
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class GymMeWebClient {

    fun getWorksheetExercises(getWorksheetExercisesResponse: GetWorksheetExercisesResponse, worksheetId: Int) {
        val call = RetrofitConfig().getWorksheetExercises().getWorksheetExercises(worksheetId)
        call.enqueue(object: Callback<Array<String>?> {
            override fun onFailure(call: Call<Array<String>?>, t: Throwable) {
                Log.e("WorksheetExercises", "Erro ao buscar os exercícios da ficha: " + t.message)
                getWorksheetExercisesResponse.faliure(t.message)
            }

            override fun onResponse(call: Call<Array<String>?>, response: Response<Array<String>?>) {
                getWorksheetExercisesResponse.success(response.body())
            }

        })
    }
}