package com.gymme.domain.handlers

import com.gymme.data.data.Base.MetricsEntity
import com.gymme.data.data.InsertExerciseMetricsResponse
import com.gymme.domain.entities.Metrics
import com.gymme.domain.entities.WorksheetExerciseMetrics
import com.gymme.domain.repositories.IMetricsRepository

class MetricsHandler(private val repository: IMetricsRepository) {
    suspend fun execute(worksheetId: Int, exerciseId: Int): Metrics {
        return repository.getMetrics(worksheetId, exerciseId)
    }

    suspend fun executeInsertExerciseMetrics(insertExerciseMetricsResponse: InsertExerciseMetricsResponse, exerciseId: Int, worksheetId: Int, metrics: MetricsEntity): WorksheetExerciseMetrics {
        return repository.insertExerciseMetrics(insertExerciseMetricsResponse, exerciseId, worksheetId, metrics)
    }
}