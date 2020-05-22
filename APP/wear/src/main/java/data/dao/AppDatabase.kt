package com.gymme.data.dao


import androidx.room.Database
import androidx.room.RoomDatabase
import com.gymme.data.data.LocalExercise

@Database(entities = arrayOf(
        LocalExercise::class
),
        version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun worksheetExercisesDao(): WorksheetExercisesDao
}