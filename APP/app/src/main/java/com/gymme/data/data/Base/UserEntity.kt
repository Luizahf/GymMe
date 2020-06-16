package com.gymme.data.data.Base

import java.io.Serializable

data class UserEntity (
        var id: Int,
        var name: String,
        var height: Int?,
        var weight: Int?,
        var gender: Char?,
        var loginId: Int
) : Serializable

data class InsertUserRequest (
        var name: String,
        var height: Int?,
        var weight: Int?,
        var gender: Char?,
        var loginId: Int
) : Serializable