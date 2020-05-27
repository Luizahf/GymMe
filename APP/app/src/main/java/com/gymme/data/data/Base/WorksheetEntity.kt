package com.gymme.data.data.Base

import java.io.Serializable

data class WorksheetEntity (
    val description: String,
    val practiceId: Int
) : Serializable