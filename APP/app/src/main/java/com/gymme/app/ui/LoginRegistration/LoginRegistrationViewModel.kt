package com.gymme.app.ui.LoginRegistration

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.data.data.InsertLoginResponse
import com.gymme.domain.entities.Login
import com.gymme.domain.handlers.LoginHandler

class LoginRegistrationViewModel(application: Application,
                                 private val loginHandler: LoginHandler) : ViewModelBase(application) {
    var login : MutableLiveData<Login> = MutableLiveData()
    var errorMessage : MutableLiveData<String> = MutableLiveData()

    fun insertLogin(requestedLogin: String, password: String) {
        doAsyncWork {
            val result = loginHandler.executeInsertLogin(object: InsertLoginResponse {
                override fun success(insertedLogin: Login) {
                    login.postValue(insertedLogin)
                }

                override fun failure(statusCode: Int?, message: String) {
                    errorMessage.postValue(message)
                }
            }, requestedLogin, password)
        }
    }
}