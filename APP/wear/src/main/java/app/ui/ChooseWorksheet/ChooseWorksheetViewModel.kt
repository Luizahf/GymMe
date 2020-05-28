package com.gymme.app.ui.ChooseWorksheet

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.domain.entities.Worksheet
import com.gymme.domain.handlers.PracticeWorksheetsHandler

class ChooseWorksheetViewModel(application: Application,
                               private val practiceWorksheetsHandler: PracticeWorksheetsHandler) : ViewModelBase(application) {

    var worksheetList = MutableLiveData<List<Worksheet>>().apply {value = null}
    var worksheetId = MutableLiveData<Int>()

    fun selectWorksheet(worksheet: String) {
        worksheetId.postValue(worksheetList.value!!.filter { wrksht -> wrksht.description == worksheet }[0].id)
    }

    fun getPracticeWorksheets(practiceId: Int) {
        doAsyncWork {
            val resultList = practiceWorksheetsHandler.execute(practiceId)
            worksheetList.postValue(resultList)
        }
    }
}