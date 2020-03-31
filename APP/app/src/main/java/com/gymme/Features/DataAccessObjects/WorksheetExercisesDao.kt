package com.raywenderlich.gymme.Features.DataAccessObjects

import android.arch.persistence.room.Insert
import com.raywenderlich.gymme.Services.dto.WorksheetExercise


interface WorksheetExercisesDao {
    @Insert
    fun insert(worksheetExercises: Array<String>) : Long
}