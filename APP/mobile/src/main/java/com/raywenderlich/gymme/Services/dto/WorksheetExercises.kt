package com.raywenderlich.gymme.Services.dto
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class WorksheetExercise: Serializable {
    @SerializedName("Exercise")
    var exercise: String? = null
}