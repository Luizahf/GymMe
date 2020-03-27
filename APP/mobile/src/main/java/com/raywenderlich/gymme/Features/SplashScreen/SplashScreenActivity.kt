package com.raywenderlich.gymme.Features.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.raywenderlich.gymme.Features.MyWorksheet.MyWorksheetActivity
import com.raywenderlich.gymme.R
import com.raywenderlich.gymme.Features.StartExercises.StartExercisesActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        btn_worksheet.setOnClickListener(this)
        btn_new_workout.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_worksheet -> {
                goToWorksheetExercises()
            }
            R.id.btn_new_workout -> {
                goToNewWorkout()
            }
        }
    }

    fun goToWorksheetExercises() {

        startActivity(Intent(this, MyWorksheetActivity::class.java))
    }

    fun goToNewWorkout() {

        startActivity(Intent(this, StartExercisesActivity::class.java))
    }
}
