package domain.handlers

import domain.entities.User
import domain.repositories.IUserRepository

class UserHandler(private val repository: IUserRepository) {
    suspend fun execute(userId: Int): User {
        return repository.getUser(userId)
    }
}