package com.gymme.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gymme.data.data.LocalMetrics

@Dao
interface MetricsDao {
    @Query("SELECT * FROM metrics")
    suspend fun get(): List<LocalMetrics>?

    @Insert
    suspend fun insert(metrics: List<LocalMetrics>)
}