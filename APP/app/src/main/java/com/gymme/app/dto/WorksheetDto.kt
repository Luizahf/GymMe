package com.gymme.app.dto

data class WorksheetDto(
        var id: Int,
        var description: String,
        var exercises: List<ExerciseDto>
)