package com.gymme.data.data.Base

import com.gymme.domain.entities.Exercise
import com.gymme.domain.entities.Worksheet
import java.io.Serializable

data class WorksheetEntity (
    var id: Int,
    val description: String,
    val practiceId: Int
) : Serializable


data class InsertWorksheetExercisesRequest (
        var worksheet: Worksheet,
        var exerciseList: List<Exercise>
) : Serializable