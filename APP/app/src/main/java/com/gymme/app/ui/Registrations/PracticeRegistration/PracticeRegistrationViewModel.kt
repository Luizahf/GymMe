package com.gymme.app.ui.Registrations.PracticeRegistration

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.data.data.InsertPracticeResponse
import com.gymme.domain.entities.Practice
import com.gymme.domain.handlers.PracticeHandler

class PracticeRegistrationViewModel ( application: Application,
                                      private val practiceHandler: PracticeHandler) : ViewModelBase(application) {
    var practice : MutableLiveData<Practice> = MutableLiveData()
    var errorMessage : MutableLiveData<String> = MutableLiveData()

    fun insertPractice(description: String, goal: String?, frequency: Int?, userId: Int) {
        doAsyncWork {
            practiceHandler.executeInsertPractice(object: InsertPracticeResponse {
                override fun success(inserted: Practice) {
                    practice.postValue(inserted)
                }

                override fun failure(statusCode: Int?, message: String) {
                    errorMessage.postValue(message)
                }
            }, description, goal, frequency, userId)
        }
    }
}