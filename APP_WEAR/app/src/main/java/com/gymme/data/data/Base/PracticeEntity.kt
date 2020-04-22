package com.gymme.data.data.Base

import java.io.Serializable
import java.util.*

data class PracticeEntity(
        var id: Int,
        var description: String,
        var goal: String?,
        var dueDate: Date?,
        var frequency: Int?,
        var userId: Int

) : Serializable