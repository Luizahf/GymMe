package com.gymme.app.ui.Registrations.PracticeRegistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.Shared.Constants
import com.gymme.app.ui.Registrations.UserRegistration.UserRegistrationActivity
import com.gymme.app.ui.Registrations.WorksheetRegistration.WorksheettRegistrationActivity
import com.gymme.app.ui.StartExercises.StartExercisesActivity
import kotlinx.android.synthetic.main.activity_practice_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PracticeRegistrationActivity : AppCompatActivity(), View.OnClickListener {
    private val practiceViewModel: PracticeRegistrationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_registration)

        practiceViewModel.practice.observe(this, Observer {
            val intent = Intent(this, WorksheettRegistrationActivity::class.java)
            intent.putExtra(Constants.PRACTICE_ID, it.id.toString())
            startActivity(intent)
        })

        practiceViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        btn_return.setOnClickListener(this)
        btn_confirm.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_return -> {
                startActivity(Intent(this, UserRegistrationActivity::class.java))
            }
            R.id.btn_confirm -> {
                if (verifyFields()) {
                    val userId = intent.getStringExtra(Constants.USER_ID)
                    practiceViewModel.insertPractice(practice_descriptiom.text.toString(), goal.text.toString(), frequency.text.toString().toIntOrNull(), userId.toInt())
                }
            }
        }
    }

    private fun verifyFields() : Boolean {
        if (practice_descriptiom.text.toString().isEmpty()) {
            Toast.makeText(this, "Nome do treino não preenchido.", Toast.LENGTH_SHORT).show()
        } else if (frequency.text.toString().isNotEmpty() && !frequency.text.toString().matches("\\d+(\\.\\d+)?".toRegex())) {
            Toast.makeText(this, "Frequência incorreta, preencha apenas com numeros.", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false
    }
}
