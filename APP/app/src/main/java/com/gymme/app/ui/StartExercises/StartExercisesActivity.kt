package com.gymme.app.ui.StartExercises

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.Shared.Constants
import com.gymme.app.ui.SplashScreen.SplashScreenActivity
import com.gymme.domain.entities.CompleteExercise
import com.gymme.domain.entities.Practice
import com.gymme.domain.entities.Worksheet
import kotlinx.android.synthetic.main.start_exercises.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartExercisesActivity : AppCompatActivity(), View.OnClickListener {
    private val startExercisesViewModel: StartExercisesViewModel by viewModel()
    var exerciseList: List<CompleteExercise> = mutableListOf()
    private var exercise: Int = 0
    var practiceList : List<Practice> = mutableListOf()
    var worksheetList : List<Worksheet> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_exercises)

        btn_right.setOnClickListener(this)
        btn_left.setOnClickListener(this)

        setInitialLayoutInfo()

        val userId = intent.getStringExtra(Constants.USER_ID)
        startExercisesViewModel.getPractices(userId.toInt())

    }

    fun setInitialLayoutInfo() {

        startExercisesViewModel.exercisesList.observe(this, Observer {
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
                        exercise = 0
                        practiceList = practices
                        setPracticeSpinner(practices)
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
                        exercise = 0
                        worksheetList = worksheets
                        setWorksheetsSpinner(worksheets)
                        startExercisesViewModel.getWorksheetExercises(worksheets[0].id)
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar as fichas do usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    fun setPracticeSpinner(practices: List<Practice>) {
        val spinnerPractices: Spinner = findViewById(R.id.spinner_practices)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, practices.map { practice -> practice.description })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPractices.adapter = adapter

        spinnerPractices.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View?, position: Int, id: Long) {
                if (position > 0) {
                    startExercisesViewModel.selectPractice(practiceList[position].description)
                } else {
                    startExercisesViewModel.selectPractice(practiceList[0].description)
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>) { }
        }
    }

    fun setWorksheetsSpinner(worksheets: List<Worksheet>) {
        val spinnerWorksheets: Spinner = findViewById(R.id.spinner_worksheets)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, worksheets.map { wrksht -> wrksht.description })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerWorksheets.adapter = adapter

        spinnerWorksheets.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View?, position: Int, id: Long) {
                if (position > 0) {
                    startExercisesViewModel.selectWorksheet(worksheetList[position].description)
                } else {
                    startExercisesViewModel.selectWorksheet(worksheetList[0].description)
                }

            }
            override fun onNothingSelected(parentView: AdapterView<*>) { }
        }
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
            execution_time.setText(time.toString() + "s")
        }
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
                finish()
            }
        }
    }
}
