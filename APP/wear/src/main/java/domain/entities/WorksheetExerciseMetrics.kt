package com.gymme.domain.entities

import java.io.Serializable

data class WorksheetExerciseMetrics  (
        var id: Int,
        val worksheetExerciseId: Int,
        val metricsId: Int
) : Serializable