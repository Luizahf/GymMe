package com.gymme.app.ui.ChoosePractice

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.entities.Practice
import com.gymme.domain.handlers.PracticeHandler

class ChoosePracticeViewModel (application: Application,
                               private val practiceHandler: PracticeHandler)  : ViewModelBase(application) {
    var practiceList = MutableLiveData<List<Practice>>().apply {value = null}
    var practiceId = MutableLiveData<Int>()

    fun getPractices(userId: Int) {
        doAsyncWork {
            val resultList = practiceHandler.execute(userId)
            practiceList.postValue(resultList)
        }
    }

    fun selectPractice(practice: String) {
        practiceId.postValue(practiceList.value!!.filter { pract -> pract.description == practice }[0].id)
    }
}