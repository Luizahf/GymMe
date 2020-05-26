package data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.data.LocalUser
import data.dao.UserDao
import data.data.Base.UserEntity
import domain.entities.User
import domain.repositories.IUserRepository

class UserRepository (
        private val dao: UserDao,
        private val api: GymMeApi
) : IUserRepository {
    override suspend fun getUser(userId: Int): User {
        try {
            val response: UserEntity? =
                    api.getUser(userId)!!.execute().body()
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