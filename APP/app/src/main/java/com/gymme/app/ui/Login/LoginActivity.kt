package com.gymme.app.ui.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gymme.R
import com.gymme.app.ui.StartExercises.StartExercisesViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_new_login.setOnClickListener(this)
        btn_confirm.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_confirm -> {
                var user = loginViewModel.getUser(login.toString(), password.toString())
                if (user != null) {

                }
                // Check if user
                // If not user change warining color
                // If user got o start exercises
            }
            R.id.btn_new_login -> {
                // Implement new registration page
            }
        }
    }
}
