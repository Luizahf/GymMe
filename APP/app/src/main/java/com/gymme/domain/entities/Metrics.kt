package com.gymme.domain.entities
import java.io.Serializable

data class Metrics (
    var Id: Int,
    var Series: Int?,
    var Repetitions: Int?,
    var Load: Int?,
    var ExecutionTime: Int?
) : Serializable