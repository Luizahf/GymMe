package com.gymme.domain.repositories

import com.gymme.domain.entities.Metrics

interface IMetricsRepository {
    suspend fun getMetrics(worksheetId: Int, exerciseId: Int) : Metrics
}