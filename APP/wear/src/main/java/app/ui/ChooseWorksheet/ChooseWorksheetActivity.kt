package com.gymme.app.ui.ChooseWorkout

import Shared.Constants
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.app.ui.ChooseWorksheet.ChooseWorksheetViewModel
import com.gymme.app.ui.StartExercises.StartExercisesActivity
import com.gymme.domain.entities.Worksheet

import kotlinx.android.synthetic.main.activity_choose_practice.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChooseWorksheetActivity : AppCompatActivity(), View.OnClickListener {
    private val chooseWorksheetViewModel: ChooseWorksheetViewModel by viewModel()
    var worksheetList : List<Worksheet> = mutableListOf()
    var selectedWorksheetId = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_worksheet)

        btn_next.setOnClickListener(this)

        val practiceId = intent.getStringExtra(Constants.PRACTICE_ID)
        chooseWorksheetViewModel.getPracticeWorksheets(practiceId.toInt())

        chooseWorksheetViewModel.worksheetList.observe(this, Observer {
            it?.let {
                worksheets ->
                run {
                    if (worksheets.isNotEmpty()) {
                        worksheetList = worksheets
                        setWorksheetSpinner(worksheets)
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar os treinos do usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        chooseWorksheetViewModel.worksheetId.observe(this, Observer {
            it?.let {
                id ->
                run {
                    if (id != null) {
                        selectedWorksheetId.postValue(id)
                    }
                }
            }
        })

    }

    fun setWorksheetSpinner(worksheets: List<Worksheet>) {
        val spinnerWorksheets: Spinner = findViewById(R.id.spinner_worksheets)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, worksheets.map { worksheets -> worksheets.description })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerWorksheets.adapter = adapter

        spinnerWorksheets.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View?, position: Int, id: Long) {
                if (position > 0) {
                    chooseWorksheetViewModel.selectWorksheet(worksheetList[position].description)
                } else {
                    chooseWorksheetViewModel.selectWorksheet(worksheetList[0].description)
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>) { }
        }
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_next -> {
                val intent = Intent(this, StartExercisesActivity::class.java)
                intent.putExtra(Constants.WORKSHEET_ID, selectedWorksheetId.value!!.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
