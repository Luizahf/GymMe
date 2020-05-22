package com.gymme.domain.entities
import java.io.Serializable

data class Practice (
    var id: Int,
    var description: String?,
    var worksheets: List<Worksheet>
) : Serializable
