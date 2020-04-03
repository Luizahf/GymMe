package com.gymme.data.data

import com.gymme.data.data.Base.ExerciseEntity
import java.io.Serializable

data class GetWorksheetExercisesResponse(
    var worksheetExercises: List<ExerciseEntity>?
) : Serializable