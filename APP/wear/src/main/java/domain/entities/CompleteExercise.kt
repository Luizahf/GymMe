package com.gymme.domain.entities
import java.io.Serializable

data class CompleteExercise (
    var exercise: Exercise,
    var metrics: Metrics
) : Serializable