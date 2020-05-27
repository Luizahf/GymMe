package com.gymme.data.dao


import androidx.room.Database
import androidx.room.RoomDatabase
import com.gymme.data.data.LocalExercise
import com.gymme.data.data.LocalUser
import data.dao.UserDao

@Database(entities = arrayOf(
        LocalExercise::class,
        LocalUser::class
),
        version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun worksheetExercisesDao(): WorksheetExercisesDao
    abstract fun userDao(): UserDao
}