package com.gymme.data.data

import com.gymme.data.data.Base.UserEntity
import java.io.Serializable

data class InsertUserResponse (
        var user : UserEntity,
        var sucess : Boolean,
        var message: String
) : Serializable