package com.gymme.app.ui.UserRegistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.app.ui.SplashScreen.SplashScreenActivity
import kotlinx.android.synthetic.main.activity_user_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserRegistrationActivity : AppCompatActivity(), View.OnClickListener {
    private val userViewModel: UserRegistrationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration)

        userViewModel.user.observe(this, Observer {
            it?.let {
                user ->
                run {
                    if (user.sucess) {
                        // TODO implement next registration
                    } else {
                        Toast.makeText(this, user.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
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
                    userViewModel.insertUser(register_login.text.toString(), password.text.toString())
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
