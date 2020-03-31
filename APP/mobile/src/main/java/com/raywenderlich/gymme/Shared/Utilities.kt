package com.raywenderlich.gymme.Shared

import android.app.Activity
import android.app.AlertDialog

object Utilities {
    fun FaliureMessage(activity: Activity, message: String?) : AlertDialog {
        var builder = AlertDialog.Builder(activity)
        builder.setTitle("")
        builder.setMessage(message)
        builder.setCancelable(false)
        builder.setNeutralButton("Ok") {dialog, _ -> dialog.dismiss()}
        return builder.create()
    }
}