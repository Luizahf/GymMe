package com.gymme.domain.entities

import com.gymme.domain.entities.User
import java.io.Serializable

data class Login (
        var login : String,
        var password: String
) : Serializable