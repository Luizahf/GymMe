package com.gymme.domain.entities
import java.io.Serializable
import java.util.*

data class Practice (
        var id: Int,
        var description: String,
        var goal: String?,
        var dueDate: Date?,
        var frequency: Int?,
        var userId: Int
) : Serializable
