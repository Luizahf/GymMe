package com.raywenderlich.gymme.Services

import android.os.AsyncTask
import android.util.Log
import com.raywenderlich.gymme.Services.dto.WorksheetExercises
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class GymMeWebClient {

    fun getWorksheetExercises(worksheetId: Int) {
        val call = RetrofitConfig().getWorksheetExercises().getWorksheetExercises(worksheetId)
        call.enqueue(object: Callback<WorksheetExercises?> {
            override fun onFailure(call: Call<WorksheetExercises?>, t: Throwable) {
                Log.e("WorksheetExercises", "Erro ao buscar os exercícios da ficha: " + t.message)
            }

            override fun onResponse(call: Call<WorksheetExercises?>, response: Response<WorksheetExercises?>) {
                val worksheetExercises: WorksheetExercises? = response.body()
            }

        })
    }
}