package com.gymme.data.data.Base

import java.io.Serializable

data class LoginEntity (
        var id: Int,
        var login: String,
        var password: String
) : Serializable