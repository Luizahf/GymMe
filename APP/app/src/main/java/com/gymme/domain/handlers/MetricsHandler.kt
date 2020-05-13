package com.gymme.domain.handlers

import com.gymme.domain.entities.Metrics
import com.gymme.domain.repositories.IMetricsRepository

class MetricsHandler(private val repository: IMetricsRepository) {
    suspend fun execute(worksheetId: Int, exerciseId: Int): Metrics {
        return repository.getMetrics(worksheetId, exerciseId)
    }
}