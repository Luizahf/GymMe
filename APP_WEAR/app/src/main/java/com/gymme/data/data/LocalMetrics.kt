package com.gymme.data.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.gymme.domain.entities.Metrics

@Entity(tableName = "metrics")
data class LocalMetrics(
        @PrimaryKey var Id: Int,
        var Series: Int?,
        var Repetitions: Int?,
        var Load: Int?,
        var ExecutionTime: Int?
) {
    @Ignore
    constructor(metrics: Metrics) :
            this(
                    metrics.Id,
                    metrics.Series,
                    metrics.Repetitions,
                    metrics.Load,
                    metrics.ExecutionTime
            )
    @Ignore
    fun get(): Metrics {
        return Metrics(
                Id,
                Series,
                Repetitions,
                Load,
                ExecutionTime
        )
    }
}