package com.gymme.data.data
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.gymme.domain.entities.Exercise

data class LocalExercise(
    @SerializedName("description")
    var description: String? = null,

    @SerializedName("id")
    var id: Int = 0
)

@Entity(tableName = "worksheet_exercises")
data class ExerciseData(
        @PrimaryKey var id: Int,
        var description: String?
) {
    @Ignore
    constructor(exercise: Exercise) :
            this(
                    exercise.id,
                    exercise.description
            )
    @Ignore
    fun get(): Exercise {
        return Exercise(
                id,
                description
        )
    }
}