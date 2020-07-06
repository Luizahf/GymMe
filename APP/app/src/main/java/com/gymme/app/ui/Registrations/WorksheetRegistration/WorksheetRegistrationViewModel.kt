package com.gymme.app.ui.Registrations.WorksheetRegistration

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gymme.app.ViewModelBase
import com.gymme.data.data.InsertWorksheetExercisesResponse
import com.gymme.domain.entities.Exercise
import com.gymme.domain.entities.Worksheet
import com.gymme.domain.handlers.WorksheetExercisesHandler
import java.util.ArrayList

class WorksheetRegistrationViewModel (application: Application,
                                      private val worksheetExercisesHandler: WorksheetExercisesHandler) : ViewModelBase(application) {
    var worksheet : MutableLiveData<Worksheet> = MutableLiveData()
    var errorMessage : MutableLiveData<String> = MutableLiveData()

    fun insertWorksheetExercises(name: String, practiceId: Int, exerciseList: ArrayList<String>) {
        var list = mutableListOf<Exercise>()
        exerciseList.forEach { ex -> run {
            list.add(Exercise(0, ex))
        } }
        doAsyncWork {
            worksheetExercisesHandler.executeinsertWorksheetExercises(object: InsertWorksheetExercisesResponse {
                override fun success(insertedWorksheet: Worksheet) {
                    worksheet.postValue(insertedWorksheet)
                }

                override fun failure(statusCode: Int?, message: String) {
                    errorMessage.postValue(message)
                }
            }, name, practiceId, list)
        }
    }
}