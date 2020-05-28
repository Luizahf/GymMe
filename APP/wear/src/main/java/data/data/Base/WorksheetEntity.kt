package com.gymme.data.data.Base

import java.io.Serializable

data class WorksheetEntity (
    var id: Int,
    val description: String,
    val practiceId: Int
) : Serializable