package com.gymme.data.data.Base

import java.io.Serializable

data class WorksheetExerciseMetricsEntity (
        var id: Int,
        val worksheetExerciseId: Int,
        val metricsId: Int
) : Serializable


data class InsertWorksheetExerciseMetricsRequest (
        var exerciseId: Int,
        val worksheetId: Int,
        val metrics: MetricsEntity
) : Serializable