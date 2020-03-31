package com.raywenderlich.gymme.Services

import android.os.AsyncTask
import com.raywenderlich.gymme.Services.dto.WorksheetExercise
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


public interface GymMeRest {
    @GET("worksheetExercises/{worksheetId}/exercises")
    fun getWorksheetExercises(@Path("worksheetId") worksheetId: Int): Call<Array<String>?>
}