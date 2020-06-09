package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.data.Base.LoginEntity
import com.gymme.domain.entities.Login
import com.gymme.domain.repositories.ILoginRepository

class LoginRepository (
        private val api: GymMeApi
) : ILoginRepository {

    override suspend fun insertLogin(login: String, password :String): Login {
        try {
            val response: LoginEntity? =
                    api.insertLogin(login, password)!!.execute().body()
            if (response != null)
            {
                return Login(
                    login = response!!.login,
                    password = response!!.password)
            }
            else {
                return Login("", "")
            }
        }
        catch(e: Exception) {
            return Login(e.message!!, "")
        }
    }
}