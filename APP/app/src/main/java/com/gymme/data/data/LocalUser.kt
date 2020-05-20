package com.gymme.data.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.gymme.domain.entities.Metrics
import com.gymme.domain.entities.User

@Entity(tableName = "users")
data class LocalUser(
        @PrimaryKey var Id: Int,
        var Name: String,
        var Height: Int?,
        var Weight: Int?,
        var Gender: Char?
) {
    @Ignore
    constructor(user: User) :
            this(
                    user.Id,
                    user.Name,
                    user.Height,
                    user.Weight,
                    user.Gender
            )
    @Ignore
    fun get(): User {
        return User(
                Id,
                Name,
                Height,
                Weight,
                Gender
        )
    }
}