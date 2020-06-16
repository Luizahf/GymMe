package com.gymme.app.ui.UserRegistration

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.data.data.InsertUserResponse
import com.gymme.domain.Responses.InsertUser
import com.gymme.domain.entities.User
import com.gymme.domain.handlers.UserHandler

class UserRegistrationViewModel(application: Application,
                                private val userHandler: UserHandler) : ViewModelBase(application) {
    var user : MutableLiveData<User> = MutableLiveData()
    var errorMessage : MutableLiveData<String> = MutableLiveData()

    fun insertUser(name: String, height: Int?, weight: Int?, loginId: Int) {
        doAsyncWork {
            userHandler.executeInsertUser(object: InsertUserResponse {
                override fun success(insertedLogin: User) {
                    user.postValue(insertedLogin)
                }

                override fun failure(statusCode: Int?, message: String) {
                    errorMessage.postValue(message)
                }
            }, name, height, weight, loginId)
        }
    }
}