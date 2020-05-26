package domain.repositories

import domain.entities.User


interface IUserRepository {
    suspend fun getUser(login: String, password :String) : User
}