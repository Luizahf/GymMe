package com.gymme.domain.entities
import java.io.Serializable

data class Worksheet (
        var id: Int,
        val description: String,
        val practiceId: Int
) : Serializable
