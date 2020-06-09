package com.gymme.app.ui.UserRegistration

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.Responses.InsertUser
import com.gymme.domain.handlers.UserHandler

class UserRegistrationViewModel(application: Application,
                                private val userHandler: UserHandler) : ViewModelBase(application) {
    var user : MutableLiveData<InsertUser> = MutableLiveData()

    fun insertUser(login: String, password: String) {
        doAsyncWork {
            val result = userHandler.executeInsertUser(login, password)
            user.postValue(result)
        }
    }
}