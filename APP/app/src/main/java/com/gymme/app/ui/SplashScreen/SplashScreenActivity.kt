package com.gymme.app.ui.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.app.ui.StartExercises.StartExercisesActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {
    private val splashScreenViewModel: SplashScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        btn_worksheet.setOnClickListener(this)
        btn_new_workout.setOnClickListener(this)

        splashScreenViewModel.worksheetExercisesList.observe(this, Observer {
            it?.let {
                exerciseList ->
                run {
                    if (exerciseList.size > 0) {

                    } else {
                        Toast.makeText(this, "Não foi possível encontrar exercícios para essa ficha.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_worksheet -> {
                splashScreenViewModel.getWorksheetExercises(1)
            }
            R.id.btn_new_workout -> {
                goToNewWorkout()
            }
        }
    }

    fun goToNewWorkout() {

        startActivity(Intent(this, StartExercisesActivity::class.java))
    }
}
