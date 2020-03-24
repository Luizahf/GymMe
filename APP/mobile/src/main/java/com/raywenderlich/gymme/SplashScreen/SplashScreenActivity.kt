package com.raywenderlich.gymme.SplashScreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.raywenderlich.gymme.R

class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnGoToWorksheet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        btnGoToWorksheet = findViewById(R.id.btn_worksheet)
        btnGoToWorksheet.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_worksheet -> {
                goToWorksheet()
            }
        }
    }

    fun goToWorksheet() {
        //val intent = Intent(this, )
    }
}
