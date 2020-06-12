package com.gymme.app.ui.UserRegistration

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.Responses.InsertUser
import com.gymme.domain.handlers.UserHandler

class UserRegistrationViewModel(application: Application,
                                private val userHandler: UserHandler) : ViewModelBase(application) {
    var user : MutableLiveData<InsertUser> = MutableLiveData()

    fun insertUser(name: String, height: Int?, weight: Int?, loginId: Int) {
        doAsyncWork {
            val result = userHandler.executeInsertUser(name, height, weight, loginId)
            user.postValue(result)
        }
    }
}