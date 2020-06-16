package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.dao.UserDao
import com.gymme.data.data.Base.InsertUserRequest
import com.gymme.data.data.Base.UserEntity
import com.gymme.data.data.InsertUserResponse
import com.gymme.data.data.LocalUser
import com.gymme.domain.Responses.InsertUser
import com.gymme.domain.entities.User
import com.gymme.domain.repositories.IUserRepository
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository (
        private val dao: UserDao,
        private val api: GymMeApi
) : IUserRepository {
    override suspend fun getUser(login: String, password :String): User {
        try {
            val response: UserEntity? =
                    api.getUser(login, password)!!.execute().body()
            if (response != null && response.id != 0)
            {
                return User(
                        Id = response!!.id,
                        Name = response!!.name,
                        Weight = response!!.weight,
                        Height = response!!.height,
                        Gender = response!!.gender

                )
            }
            else {
                return User(0, "", null, null, null)
            }
        }
        catch(e: Exception) {
            val message = "Falha ao obter usuário."
            throw Exception(message)
        }
    }

    override suspend fun insertUser(insertUserResponse: InsertUserResponse, name: String, height: Int?, weight: Int?, loginId: Int): User {
        val call = api.insertUser(InsertUserRequest(name, height, weight, null, loginId))

        call!!.enqueue(object: Callback<UserEntity?> {
            override fun onFailure(call: Call<UserEntity?>, t: Throwable) {
            }

            override fun onResponse(call: Call<UserEntity?>, response: Response<UserEntity?>) {
                if (response?.code() == 400) {
                    val jObjError = JSONArray(response.errorBody()!!.string())
                    insertUserResponse.failure(400, jObjError.getString(0))
                } else if (response.isSuccessful) {
                    val insertedLogin : UserEntity? = response.body()
                    insertUserResponse.success(User(
                            Id = insertedLogin!!.id,
                            Name = insertedLogin.name,
                            Weight = insertedLogin.weight,
                            Height = insertedLogin.height,
                            Gender = insertedLogin.gender))
                }
            }
        })

        return User(0,"", null, null,null)
    }

    suspend fun insert(userLocal: LocalUser) {
        dao.insert(userLocal)
    }
}