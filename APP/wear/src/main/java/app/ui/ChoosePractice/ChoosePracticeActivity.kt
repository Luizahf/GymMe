package com.gymme.app.ui.ChoosePractice

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
import com.gymme.app.ui.ChooseWorkout.ChooseWorkoutActivity
import com.gymme.domain.entities.Practice

import kotlinx.android.synthetic.main.activity_choose_practice.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChoosePracticeActivity : AppCompatActivity(), View.OnClickListener {
    private val choosePracticeViewModel: ChoosePracticeViewModel by viewModel()
    var practiceList : List<Practice> = mutableListOf()
    var selectedPracticeId = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_practice)

        btn_next.setOnClickListener(this)

        val userId = intent.getStringExtra(Constants.USER_ID)
        choosePracticeViewModel.getPractices(1)

        choosePracticeViewModel.practiceList.observe(this, Observer {
            it?.let {
                practices ->
                run {
                    if (practices.isNotEmpty()) {
                        practiceList = practices
                        setPracticeSpinner(practices)
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar os treinos do usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        choosePracticeViewModel.practiceId.observe(this, Observer {
            it?.let {
                id ->
                run {
                    if (id != null) {
                        selectedPracticeId.postValue(id)
                    }
                }
            }
        })

    }

    fun setPracticeSpinner(practices: List<Practice>) {
        val spinnerPractices: Spinner = findViewById(R.id.spinner_worksheets)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, practices.map { practice -> practice.description })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPractices.adapter = adapter

        spinnerPractices.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View?, position: Int, id: Long) {
                if (position > 0) {
                    choosePracticeViewModel.selectPractice(practiceList[position].description)
                } else {
                    choosePracticeViewModel.selectPractice(practiceList[0].description)
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>) { }
        }
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_next -> {
                val intent = Intent(this, ChooseWorkoutActivity::class.java)
                intent.putExtra(Constants.PRACTICE_ID, selectedPracticeId.value!!.toString())
                startActivity(intent)
                finish()
            }
        }
    }

}
