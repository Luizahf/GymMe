package com.gymme.domain.entities

import java.io.Serializable

data class PracticeWorksheets (
    var id: Int,
    var description: String?,
    var worksheets: List<Worksheet>
) : Serializable