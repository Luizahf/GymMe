package com.gymme.domain.entities
import java.io.Serializable

data class Worksheet (
    var id: Int,
    var description: String?,
    var exercises: List<Exercise>
) : Serializable
