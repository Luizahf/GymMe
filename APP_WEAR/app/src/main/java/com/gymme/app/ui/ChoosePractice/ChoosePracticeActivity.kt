package com.gymme.app.ui.ChoosePractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gymme.R
import com.gymme.app.ui.ChooseWorkout.ChooseWorkoutActivity

import kotlinx.android.synthetic.main.activity_choose_practice.*

class ChoosePracticeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_practice)

        btn_next.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_next -> {
                startActivity(Intent(this, ChooseWorkoutActivity::class.java))
                finish()
            }
        }
    }

}
