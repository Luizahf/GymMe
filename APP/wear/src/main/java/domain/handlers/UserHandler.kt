package domain.handlers

import domain.entities.User
import domain.repositories.IUserRepository

class UserHandler(private val repository: IUserRepository) {
    suspend fun execute(login: String, password :String): User {
        return repository.getUser(login, password)
    }
}