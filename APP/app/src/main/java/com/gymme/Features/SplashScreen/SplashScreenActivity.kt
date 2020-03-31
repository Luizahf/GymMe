package com.raywenderlich.gymme.Features.SplashScreen

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.raywenderlich.gymme.Features.MyWorksheet.MyWorksheetActivity
import com.raywenderlich.gymme.Features.MyWorksheet.MyWorksheetViewModel
import com.raywenderlich.gymme.Features.MyWorksheet.WorksheetAdapter
import com.raywenderlich.gymme.R
import com.raywenderlich.gymme.Features.StartExercises.StartExercisesActivity
import com.raywenderlich.gymme.Services.GymMeWebClient
import com.raywenderlich.gymme.Services.Responses.GetWorksheetExercisesResponse
import com.raywenderlich.gymme.Services.dto.WorksheetExercise
import com.raywenderlich.gymme.Shared.Utilities
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {
   // private lateinit val myWorksheetViewModel: MyWorksheetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //myWorksheetViewModel = ViewModelProviders.of(this, Injec)

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
        GymMeWebClient().getWorksheetExercises(object: GetWorksheetExercisesResponse {
            override fun success(worksheetExercises: Array<String>?) {
                startActivity(Intent(this@SplashScreenActivity, MyWorksheetActivity::class.java))
                //MyWorksheetViewModel().
            }

            override fun faliure(message: String?) {
                Utilities.FaliureMessage(this@SplashScreenActivity, message)
            }

        }, 1)
    }

    fun goToNewWorkout() {

        startActivity(Intent(this, StartExercisesActivity::class.java))
    }
}
