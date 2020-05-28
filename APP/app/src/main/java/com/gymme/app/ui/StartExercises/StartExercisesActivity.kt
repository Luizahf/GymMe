package com.gymme.app.ui.StartExercises

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.Shared.Constants
import com.gymme.app.ui.SplashScreen.SplashScreenActivity
import com.gymme.domain.entities.Exercise
import com.gymme.domain.entities.Practice
import com.gymme.domain.entities.Worksheet
import kotlinx.android.synthetic.main.start_exercises.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartExercisesActivity : AppCompatActivity(), View.OnClickListener {
    private val startExercisesViewModel: StartExercisesViewModel by viewModel()
    var exerciseList: List<Exercise> = mutableListOf()
    private var exercise: Int = 0
    var practiceList : List<Practice> = mutableListOf()
    var worksheetList : List<Worksheet> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_exercises)

        btn_right.setOnClickListener(this)
        btn_left.setOnClickListener(this)

        var spinnerWorksheetsAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.start_exercises, R.id.spinner_worksheets)
        setInitialLayoutInfo()
    }

    fun setInitialLayoutInfo() {

        val userId = intent.getStringExtra(Constants.USER_ID).toInt()
        startExercisesViewModel.getPractices(userId)

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

        startExercisesViewModel.practiceList.observe(this, Observer {
            it?.let {
                practices ->
                run {
                    if (practices.isNotEmpty()) {
                        practiceList = practices
                        startExercisesViewModel.getPracticeWorksheets(practices[0].id)
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar os treinos do usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        startExercisesViewModel.worksheetList.observe(this, Observer {
            it?.let {
                worksheets ->
                run {
                    if (worksheets.isNotEmpty()) {
                        worksheetList = worksheets
                        startExercisesViewModel.getWorksheetExercises(worksheets[0].id)
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar os treinos do usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        // Put values in the spinners


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
