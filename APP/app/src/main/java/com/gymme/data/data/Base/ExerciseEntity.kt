package com.gymme.data.data.Base

import java.io.Serializable

data class ExerciseEntity(
        var id: Int,
        var description: String?
) : Serializable