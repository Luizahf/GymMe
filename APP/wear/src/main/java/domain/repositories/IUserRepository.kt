package domain.repositories

import domain.entities.User


interface IUserRepository {
    suspend fun getUser(userId: Int) : User
}