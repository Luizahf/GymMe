package com.gymme.data.repositories

import com.gymme.data.api.GymMeApi
import com.gymme.data.dao.MetricsDao
import com.gymme.data.data.Base.InsertWorksheetExerciseMetricsRequest
import com.gymme.data.data.Base.MetricsEntity
import com.gymme.data.data.Base.WorksheetExerciseMetricsEntity
import com.gymme.data.data.InsertExerciseMetricsResponse
import com.gymme.data.data.LocalMetrics
import com.gymme.domain.entities.Metrics
import com.gymme.domain.entities.WorksheetExerciseMetrics
import com.gymme.domain.repositories.IMetricsRepository
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MetricsRepository (
        private val dao: MetricsDao,
        private val api: GymMeApi
) : IMetricsRepository {

    override suspend fun getMetrics(worksheetId: Int, exerciseId: Int): Metrics {
        try {
            val response: MetricsEntity? =
                    api.getMetrics(worksheetId, exerciseId)!!.execute().body()
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
    override suspend fun insertExerciseMetrics(insertExerciseMetricsResponse: InsertExerciseMetricsResponse, exerciseId: Int, worksheetId: Int, metrics: MetricsEntity): WorksheetExerciseMetrics {
        val call = api.insertExerciseMetrics(InsertWorksheetExerciseMetricsRequest(exerciseId, worksheetId, metrics))

        call!!.enqueue(object: Callback<WorksheetExerciseMetricsEntity?> {
            override fun onFailure(call: Call<WorksheetExerciseMetricsEntity?>, t: Throwable) {
            }

            override fun onResponse(call: Call<WorksheetExerciseMetricsEntity?>, response: Response<WorksheetExerciseMetricsEntity?>) {
                if (response?.code() == 400) {
                    val jObjError = JSONArray(response.errorBody()!!.string())
                    insertExerciseMetricsResponse.failure(400, jObjError.getString(0))
                } else if (response.isSuccessful) {
                    val insertedMetrics : WorksheetExerciseMetricsEntity? = response.body()
                    insertExerciseMetricsResponse.success(WorksheetExerciseMetrics(
                            id = insertedMetrics!!.id,
                            worksheetExerciseId = insertedMetrics.worksheetExerciseId,
                            metricsId = insertedMetrics.metricsId))
                }
            }
        })

        return WorksheetExerciseMetrics(0,0, 0)
    }



    suspend fun insert(metricLocal: List<LocalMetrics>) {
        dao.insert(metricLocal)
    }
}