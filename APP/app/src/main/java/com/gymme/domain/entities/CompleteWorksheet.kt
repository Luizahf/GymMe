package com.gymme.domain.entities
import java.io.Serializable

data class CompleteWorksheet(
    var exercises: List<CompleteExercise>,
    var worksheetName: String
) : Serializable