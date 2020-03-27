package com.raywenderlich.gymme.Services.dto
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class WorksheetExercises : Serializable {
    @SerializedName("Exercises")
    var exercises: List<String>? = null
}