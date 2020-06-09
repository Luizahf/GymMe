package com.gymme.app.ui.LoginRegistration

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.entities.Login
import com.gymme.domain.handlers.LoginHandler

class LoginRegistrationViewModel(application: Application,
                                 private val loginHandler: LoginHandler) : ViewModelBase(application) {
    var login : MutableLiveData<Login> = MutableLiveData()

    fun insertUser(login: String, password: String) {
        doAsyncWork {
            val result = loginHandler.executeInsertLogin(login, password)
            this.login.postValue(result)
        }
    }
}