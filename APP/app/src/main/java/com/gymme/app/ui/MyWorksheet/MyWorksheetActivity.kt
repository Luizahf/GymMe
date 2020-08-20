package com.gymme.app.ui.MyWorksheet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gymme.R
import com.gymme.Shared.Constants
import com.gymme.app.ui.StartExercises.StartExercisesActivity
import com.gymme.domain.entities.CompleteWorksheet
import com.gymme.domain.entities.Practice
import com.gymme.domain.entities.Worksheet
import kotlinx.android.synthetic.main.activity_my_worksheet.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyWorksheetActivity : AppCompatActivity(), View.OnClickListener {
    private val myWorksheetViewModel: MyWorksheetViewModel by viewModel()
    private lateinit var worksheetsRecyclerView: RecyclerView
    var worksheetList : List<Worksheet> = mutableListOf()
    var practiceList : List<Practice> = mutableListOf()
    var user: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_worksheet)

        worksheetsRecyclerView = findViewById(R.id.worksheets)
        worksheetsRecyclerView.layoutManager = LinearLayoutManager(this)

        user = intent.getStringExtra(Constants.USER_ID).toInt()
        userName.text = intent.getStringExtra(Constants.USER_NAME)
        myWorksheetViewModel.getPractices(user)

        myWorksheetViewModel.practiceList.observe(this, Observer {
            it?.let {
                practices ->
                run {
                    if (practices.isNotEmpty()) {
                        practiceList = practices
                        setPracticeSpinner(practices)
                        myWorksheetViewModel.getPracticeWorksheets(practices[0].id)
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar os treinos do usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        myWorksheetViewModel.worksheetList.observe(this, Observer {
            it?.let {
                worksheets ->
                run {
                    if (worksheets.isNotEmpty()) {
                            myWorksheetViewModel.getWorksheetExercises(worksheets)
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar as fichas do usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        myWorksheetViewModel.exercisesList.observe(this, Observer {
            it?.let {
                exercises ->
                run {
                    if (exercises.isNotEmpty()) {
                        worksheetsRecyclerView.adapter = WorksheetAdapter(this, exercises, R.layout.worksheet_exercise_layout, R.id.exercise_description, this::clickListnerWorksheet)
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar exercícios para essa ficha.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    fun clickListnerWorksheet(position: Int) {
        var intent = Intent(this, StartExercisesActivity::class.java)
        intent.putExtra(Constants.USER_ID, user.toString())
        startActivity(intent)
    }

    private fun setPracticeSpinner(practices: List<Practice>) {
        val spinnerPractices: Spinner = findViewById(R.id.spinner_practices2)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, practices.map { practice -> practice.description })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPractices.adapter = adapter

        spinnerPractices.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View?, position: Int, id: Long) {
                myWorksheetViewModel.getPracticeWorksheets(practices[position].id)
            }
            override fun onNothingSelected(parentView: AdapterView<*>) { }
        }
    }


    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
