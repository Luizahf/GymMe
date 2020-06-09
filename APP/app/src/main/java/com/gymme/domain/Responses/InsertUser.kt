package com.gymme.domain.Responses

import com.gymme.domain.entities.User
import java.io.Serializable

data class InsertUser (
        var user : User,
        var sucess : Boolean,
        var message: String
) : Serializable