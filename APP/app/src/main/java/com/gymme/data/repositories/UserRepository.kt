package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.dao.UserDao
import com.gymme.data.data.Base.UserEntity
import com.gymme.data.data.InsertUserResponse
import com.gymme.data.data.LocalUser
import com.gymme.domain.Responses.InsertUser
import com.gymme.domain.entities.User
import com.gymme.domain.repositories.IUserRepository

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

    override suspend fun insertUser(name: String, height: Int?, weight: Int?, loginId: Int): InsertUser {
        try {
            val response: InsertUserResponse? =
                    api.insertUser(name, height, weight, null, loginId)!!.execute().body()
            if (response != null && response.sucess)
            {
                return InsertUser (
                    User(
                        Id = response!!.user.id,
                        Name = response!!.user.name,
                        Weight = response!!.user.weight,
                        Height = response!!.user.height,
                        Gender = response!!.user.gender
                    ),
                    response.sucess,
                    response.message
                )
            }
            else if (response != null) {
                return InsertUser ( User(0, "", null, null, null), response.sucess, response.message)
            } else {
                return InsertUser ( User(0, "", null, null, null), false, "Falha ao inserir usuário.")
            }
        }
        catch(e: Exception) {
            val message = "Falha ao inserir usuário."
            throw Exception(message)
        }
    }

    suspend fun insert(userLocal: LocalUser) {
        dao.insert(userLocal)
    }
}