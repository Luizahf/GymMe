package data.data.Base

import java.io.Serializable

data class UserEntity (
        var Id: Int,
        var Name: String,
        var Height: Int?,
        var Weight: Int?,
        var Gender: Char?
) : Serializable