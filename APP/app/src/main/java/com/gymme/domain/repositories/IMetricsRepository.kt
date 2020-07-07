package com.gymme.domain.repositories

import com.gymme.data.data.Base.MetricsEntity
import com.gymme.data.data.InsertExerciseMetricsResponse
import com.gymme.domain.entities.Metrics
import com.gymme.domain.entities.WorksheetExerciseMetrics

interface IMetricsRepository {
    suspend fun getMetrics(worksheetId: Int, exerciseId: Int) : Metrics
    suspend fun insertExerciseMetrics(insertExerciseMetricsResponse: InsertExerciseMetricsResponse, exerciseId: Int, worksheetId: Int, metrics: MetricsEntity): WorksheetExerciseMetrics
}