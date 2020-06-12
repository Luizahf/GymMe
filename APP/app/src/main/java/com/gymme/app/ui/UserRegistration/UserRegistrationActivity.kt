package com.gymme.app.ui.UserRegistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.Shared.Constants
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
                    val loginId = intent.getStringExtra(Constants.LOGIN_ID)
                    userViewModel.insertUser(user_name.text.toString(), user_height.text.toString().toIntOrNull(), user_weight.text.toString().toIntOrNull(), loginId.toInt())
                }
            }
        }
    }

    private fun verifyFields() : Boolean {
        if (user_name.text.toString().isEmpty()) {
            Toast.makeText(this, "Nome não preenchido.", Toast.LENGTH_SHORT).show()
        } else if (!user_height.text.toString().matches("\\d+(\\.\\d+)?".toRegex())) {
            Toast.makeText(this, "Altura incorreta, preencha apenas com numeros.", Toast.LENGTH_SHORT).show()
        } else if (!user_weight.text.toString().matches("\\d+(\\.\\d+)?".toRegex())) {
            Toast.makeText(this, "Peso incorreto, preencha apenas com numeros.", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false
    }
}
