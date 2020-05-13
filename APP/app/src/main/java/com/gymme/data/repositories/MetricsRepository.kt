package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.dao.MetricsDao
import com.gymme.data.data.Base.MetricsEntity
import com.gymme.data.data.LocalMetrics
import com.gymme.domain.entities.Metrics
import com.gymme.domain.repositories.IMetricsRepository

class MetricsRepository (
        private val dao: MetricsDao,
        private val api: GymMeApi
) : IMetricsRepository {

    override suspend fun getMetrics(worksheetId: Int, exerciseId: Int): Metrics {
        try {
            val response: MetricsEntity? =
                    api.getMetrics(worksheetId, exerciseId).execute().body()
            if (response != null)
            {
                return Metrics(
                        Id = response!!.id,
                        Series = response.series,
                        Repetitions = response.repetitions,
                        Load = response.load,
                        ExecutionTime = response.executionTime
                )
            }
            else {
                return Metrics(0, null, null, null, null)
            }
        }
        catch(e: Exception) {
            val message = "Falha ao obter as metricas do exercício."
            throw Exception(message)
        }
    }

    suspend fun insert(metricLocal: List<LocalMetrics>) {
        dao.insert(metricLocal)
    }
}