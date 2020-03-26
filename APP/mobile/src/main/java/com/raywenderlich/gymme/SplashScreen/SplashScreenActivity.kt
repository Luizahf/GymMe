package com.raywenderlich.gymme.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.raywenderlich.gymme.MyWorksheet.MyWorksheetActivity
import com.raywenderlich.gymme.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        btn_worksheet.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_worksheet -> {
                goToWorksheetExercises()
            }
        }
    }

    fun goToWorksheetExercises() {
        startActivity(Intent(this, MyWorksheetActivity::class.java))
    }
}
