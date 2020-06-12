package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.data.Base.LoginEntity
import com.gymme.data.data.InsertLoginResponse
import com.gymme.domain.entities.Login
import com.gymme.domain.repositories.ILoginRepository
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import android.R.string
import org.json.JSONArray
import org.json.JSONObject



class LoginRepository (
        private val api: GymMeApi
) : ILoginRepository {

    override suspend fun insertLogin(insertLoginResponse: InsertLoginResponse, login: String, password :String): Login {
        val call = api.insertLogin(login, password)

        call!!.enqueue(object: Callback<LoginEntity?> {
            override fun onFailure(call: Call<LoginEntity?>, t: Throwable) {

            }

            override fun onResponse(call: Call<LoginEntity?>, response: Response<LoginEntity?>) {
                if (response?.code() == 400) {
                    val jObjError = JSONArray(response.errorBody()!!.string())
                    insertLoginResponse.failure(400, jObjError.getString(0))
                } else if (response.isSuccessful) {
                    val insertedLogin : LoginEntity? = response.body()
                    insertLoginResponse.success(Login(
                                    id = insertedLogin!!.id,
                                    login = insertedLogin.login,
                                    password = insertedLogin.password))
                }
            }
        })

        return Login(0,"", "")
    }
}