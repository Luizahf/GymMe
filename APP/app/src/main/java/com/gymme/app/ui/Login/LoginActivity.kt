package com.gymme.app.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gymme.R
import androidx.lifecycle.Observer
import com.gymme.Shared.Constants
import com.gymme.app.ui.StartExercises.StartExercisesActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel.user.observe(this, Observer {
            it?.let {
                user ->
                run {
                    if (user != null) {
                        val intent = Intent(this, StartExercisesActivity::class.java)
                        intent.putExtra(Constants.USER_ID, user.Id)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Login ou senha incorretos.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        btn_new_login.setOnClickListener(this)
        btn_confirm.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_confirm -> {
                loginViewModel.getUser(login.toString(), password.toString())
            }
            R.id.btn_new_login -> {
                // Implement new registration page
            }
        }
    }
}
