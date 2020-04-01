package com.gymme.domain.entities
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Exercise (
    var id: Int,
    var description: String?
) : Serializable
