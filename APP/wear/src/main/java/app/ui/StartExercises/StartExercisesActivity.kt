package com.gymme.app.ui.StartExercises

import Shared.Constants
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.app.ui.SplashScreen.SplashScreenActivity
import com.gymme.domain.entities.CompleteExercise
import com.gymme.domain.entities.Exercise
import kotlinx.android.synthetic.main.start_exercises.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartExercisesActivity : AppCompatActivity(), View.OnClickListener {
    private val startExercisesViewModel: StartExercisesViewModel by viewModel()
    var exerciseList: List<CompleteExercise> = mutableListOf()
    private var exercise: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_exercises)


        val worksheetId = intent.getStringExtra(Constants.WORKSHEET_ID)
        startExercisesViewModel.getWorksheetExercises(worksheetId.toInt())

        btn_right.setOnClickListener(this)
        btn_left.setOnClickListener(this)
        btn_finish.setOnClickListener(this)

        startExercisesViewModel.exercisesList.observe(this, Observer {
            it?.let {
                exercises ->
                run {
                    if (exercises.isNotEmpty()) {
                        exerciseList = exercises
                        exercise = 0
                        setDisplay()
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar exercícios para essa ficha.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    fun setDisplay() {
        var description = exerciseList[exercise].exercise.description
        val ser = exerciseList[exercise].metrics.Series
        val repet = exerciseList[exercise].metrics.Repetitions
        val loads = exerciseList[exercise].metrics.Load
        val time = exerciseList[exercise].metrics.ExecutionTime

        exercise_description.setText(description)
        if (ser != null) {
            series.setText(ser.toString() + " x ")
        }
        if (repet != null) {
            repetitions.setText(repet.toString())
        }
        if(loads != null) {
            load.setText(loads.toString() + "Kg")
        }
        if (time != null) {
            load2.setText(time.toString() + "s")
        }
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_right -> {
                if (exerciseList != null && !exerciseList.isEmpty() && exercise !== exerciseList.size-1) {
                    exercise++
                    setDisplay()
                }
            }
            R.id.btn_left -> {
                if (exercise !== 0) {
                    exercise--
                    setDisplay()
                }
            }
            R.id.btn_finish -> {
                startActivity(Intent(this, SplashScreenActivity::class.java))
            }
        }
    }
}
