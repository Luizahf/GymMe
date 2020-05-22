package com.gymme.domain.entities
import java.io.Serializable

data class Exercise (
    var id: Int,
    var description: String?
) : Serializable
