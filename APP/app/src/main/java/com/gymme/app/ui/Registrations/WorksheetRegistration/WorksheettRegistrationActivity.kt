package com.gymme.app.ui.Registrations.WorksheetRegistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gymme.R
import com.gymme.Shared.Constants
import com.gymme.app.ui.Registrations.PracticeRegistration.PracticeRegistrationActivity
import com.gymme.app.ui.StartExercises.StartExercisesActivity
import kotlinx.android.synthetic.main.activity_worksheet_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class WorksheettRegistrationActivity : AppCompatActivity(), View.OnClickListener {
    private val worksheetRegistrationViewModel: WorksheetRegistrationViewModel by viewModel()
    private lateinit var worksheetsRecyclerView: RecyclerView
    private val exerciseList : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worksheet_registration)

        worksheetRegistrationViewModel.worksheet.observe(this, Observer {
            val intent = Intent(this, StartExercisesActivity::class.java)
            intent.putExtra(Constants.WORKSHEET_ID, it.id.toString())
            startActivity(intent)
        })

        worksheetRegistrationViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        worksheetsRecyclerView = findViewById(R.id.exercises)
        worksheetsRecyclerView.layoutManager = LinearLayoutManager(this)

        btn_return.setOnClickListener(this)
        btn_confirm.setOnClickListener(this)
        btn_add_exercise.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_return -> {
                startActivity(Intent(this, PracticeRegistrationActivity::class.java))
            }
            R.id.btn_add_exercise -> {
                if(verifyExerciseField()) {
                    exerciseList.add(exercise_description.text.toString())
                    worksheetsRecyclerView.adapter = RegisterWorksheetAdapter(this, R.layout.exercise_item_layout, R.id.exercise_description, exerciseList)
                    exercise_description.setText("")
                }
            }
            R.id.btn_confirm -> {
                if (verifyFields()) {
                    val practiceId = intent.getStringExtra(Constants.PRACTICE_ID).toString()
                    worksheetRegistrationViewModel.insertWorksheetExercises(workout_descriptiom.text.toString(), practiceId.toIntOrNull()!!, exerciseList)
                }
            }
        }
    }

    private fun verifyFields() : Boolean {
        if (workout_descriptiom.text.toString().isEmpty()) {
            Toast.makeText(this, "Nome da ficha não preenchido.", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false
    }

    private fun verifyExerciseField() : Boolean {
        if (exercise_description.text.toString().isEmpty()) {
            Toast.makeText(this, "Nome do exercicio não preenchido.", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false
    }

}
