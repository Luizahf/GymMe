package com.gymme.app.ui.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.gymme.R
import com.gymme.Shared.Constants
import com.gymme.app.ui.Login.LoginActivity
import com.gymme.app.ui.MyWorksheet.MyWorksheetActivity
import com.gymme.app.ui.StartExercises.StartExercisesActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        btn_worksheet.setOnClickListener(this)
        btn_new_workout.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_worksheet -> {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra(Constants.GO_TO_START_EXERCISES, "false")
                startActivity(intent)
            }
            R.id.btn_new_workout -> {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra(Constants.GO_TO_START_EXERCISES, "true")
                startActivity(intent)
            }
        }
    }
}
