package com.gymme.app.ui.StartExercises

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.app.ui.SplashScreen.SplashScreenActivity
import com.gymme.domain.entities.Exercise
import kotlinx.android.synthetic.main.start_exercises.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartExercisesActivity : AppCompatActivity(), View.OnClickListener {
    private val startExercisesViewModel: StartExercisesViewModel by viewModel()
    var exerciseList: List<Exercise> = mutableListOf()
    private var exercise: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_exercises)

        btn_right.setOnClickListener(this)
        btn_left.setOnClickListener(this)
        btn_finish.setOnClickListener(this)

        startExercisesViewModel.worksheetExercisesList.observe(this, Observer {
            it?.let {
                exercises ->
                run {
                    if (exercises.isNotEmpty()) {
                        exerciseList = exercises
                        setDisplay()
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar exercícios para essa ficha.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        var spinnerWorksheetsAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.start_exercises, R.id.spinner_worksheets)

        startExercisesViewModel.getWorksheetExercises(1)
    }

    fun setDisplay() {
        var description = exerciseList[exercise].description
        exercise_description.setText(description)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_right -> {
                if (exercise !== exerciseList.size-1) {
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
