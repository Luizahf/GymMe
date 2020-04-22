package com.gymme.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gymme.data.data.LocalExercise

@Dao
interface WorksheetExercisesDao {
    @Query("SELECT * FROM worksheet_exercises")
    suspend fun get(): List<LocalExercise>?

    @Insert
    suspend fun insert(exercises: List<LocalExercise>)
}