package com.gymme.data.data.Base

import java.io.Serializable

data class MetricsEntity(
        var id: Int,
        var series: Int?,
        var repetitions: Int?,
        var load: Int?,
        var executionTime: Int?
) : Serializable