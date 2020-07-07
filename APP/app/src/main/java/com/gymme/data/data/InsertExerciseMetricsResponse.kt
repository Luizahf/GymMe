package com.gymme.data.data

import com.gymme.domain.entities.WorksheetExerciseMetrics

interface InsertExerciseMetricsResponse {
    fun failure(statusCode: Int?, message: String)
    fun success(worksheetExerciseMetrics: WorksheetExerciseMetrics)
}