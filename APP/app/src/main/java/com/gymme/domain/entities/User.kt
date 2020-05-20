package com.gymme.domain.entities
import java.io.Serializable

data class User (
        var Id: Int,
        var Name: String,
        var Height: Int?,
        var Weight: Int?,
        var Gender: Char?
) : Serializable