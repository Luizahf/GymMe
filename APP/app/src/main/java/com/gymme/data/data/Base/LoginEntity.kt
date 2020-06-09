package com.gymme.data.data.Base

import java.io.Serializable

data class LoginEntity (
        var login: String,
        var password: String
) : Serializable