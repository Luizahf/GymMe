package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.dao.UserDao
import com.gymme.data.data.Base.UserEntity
import com.gymme.data.data.LocalUser
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
            if (response != null)
            {
                return User(
                        Id = response!!.Id,
                        Name = response!!.Name,
                        Weight = response!!.Weight,
                        Height = response!!.Height,
                        Gender = response!!.Gender

                )
            }
            else {
                return User(0, "", null, null, null)
            }
        }
        catch(e: Exception) {
            val message = "Falha ao obter as metricas do exercício."
            throw Exception(message)
        }
    }


    suspend fun insert(userLocal: LocalUser) {
        dao.insert(userLocal)
    }
}