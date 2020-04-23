package com.gymme.app.ui.ChoosePractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.gymme.R
import com.gymme.app.ui.StartExercises.StartExercisesActivity

import kotlinx.android.synthetic.main.activity_choose_practice.*
import kotlinx.android.synthetic.main.activity_splash_screen.*

class ChooseWorkoutActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_workout)

        btn_next.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_next -> {
                startActivity(Intent(this, StartExercisesActivity::class.java))
            }
        }
    }

}
