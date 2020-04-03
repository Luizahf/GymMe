package com.gymme.app.dto

data class PracticeDto(
        var id: Int,
        var description: String,
        var Worksheets: List<WorksheetDto>
)