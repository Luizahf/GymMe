package com.gymme.app.ui.Login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.entities.User
import com.gymme.domain.handlers.UserHandler

class LoginViewModel(application: Application,
                     private val userHandler: UserHandler) : ViewModelBase(application) {
    var user : MutableLiveData<User> = MutableLiveData()

    fun getUser(login: String, password: String) {
        doAsyncWork {
            //user = userHandler.execute(login, password)
        }
    }
}