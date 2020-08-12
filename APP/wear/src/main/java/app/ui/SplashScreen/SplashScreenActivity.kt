package com.gymme.app.ui.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gymme.R
import com.gymme.app.ui.ChoosePractice.ChoosePracticeActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        btn_start.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_start -> {
                startActivity(Intent(this, ChoosePracticeActivity::class.java))
                finish()
            }
        }
    }
}
