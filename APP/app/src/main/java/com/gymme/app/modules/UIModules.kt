package com.gymme.app.modules

import com.gymme.app.ui.Login.LoginViewModel
import com.gymme.app.ui.MyWorksheet.MyWorksheetViewModel
import com.gymme.app.ui.StartExercises.StartExercisesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val UIModules = module {

    viewModel {
        StartExercisesViewModel(
                get(),
                get(),
                get(),
                get()
        )
    }

    viewModel {
        MyWorksheetViewModel(
                get(),
                get()
        )
    }

    viewModel {
        LoginViewModel(
                get(),
                get()
        )
    }
}