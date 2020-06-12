package com.gymme.app.ui.LoginRegistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.Shared.Constants
import com.gymme.app.ui.SplashScreen.SplashScreenActivity
import com.gymme.app.ui.UserRegistration.UserRegistrationActivity
import kotlinx.android.synthetic.main.activity_login_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginRegistrationActivity : AppCompatActivity(), View.OnClickListener {
    private val loginViewModel: LoginRegistrationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_registration)

        loginViewModel.login.observe(this, Observer {
            val intent = Intent(this, UserRegistrationActivity::class.java)
            intent.putExtra(Constants.LOGIN_ID, it.id.toString())
            startActivity(intent)
        })

        loginViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        btn_return.setOnClickListener(this)
        btn_confirm.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_return -> {
                startActivity(Intent(this, SplashScreenActivity::class.java))
            }
            R.id.btn_confirm -> {
                if (verifyFields()) {
                    loginViewModel.insertLogin(register_login.text.toString(), password.text.toString())
                }
            }
        }
    }

    private fun verifyFields() : Boolean {
        if (register_login.text.toString() == "") {
            Toast.makeText(this, "Login não preenchido.", Toast.LENGTH_SHORT).show()
        } else if (password.text.toString() == "") {
            Toast.makeText(this, "Senha não preenchida.", Toast.LENGTH_SHORT).show()
        } else if (password.text.toString() != confirm_password.text.toString()) {
            Toast.makeText(this, "As senhas não combinam.", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false
    }
}
