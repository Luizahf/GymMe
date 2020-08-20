package com.gymme.app.modules

import com.gymme.app.ui.Login.LoginViewModel
import com.gymme.app.ui.Registrations.LoginRegistration.LoginRegistrationViewModel
import com.gymme.app.ui.MyWorksheet.MyWorksheetViewModel
import com.gymme.app.ui.Registrations.PracticeRegistration.PracticeRegistrationViewModel
import com.gymme.app.ui.StartExercises.StartExercisesViewModel
import com.gymme.app.ui.Registrations.UserRegistration.UserRegistrationViewModel
import com.gymme.app.ui.Registrations.WorksheetRegistration.WorksheetRegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val UIModules = module {

    viewModel {
        StartExercisesViewModel(
                get(),
                get(),
                get(),
                get(),
                get()
        )
    }

    viewModel {
        MyWorksheetViewModel(
                get(),
                get(),
                get(),
                get(),
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

    viewModel {
        UserRegistrationViewModel(
                get(),
                get()
        )
    }

    viewModel {
        LoginRegistrationViewModel(
                get(),
                get()
        )
    }

    viewModel {
        PracticeRegistrationViewModel(
                get(),
                get()
        )
    }

    viewModel {
        WorksheetRegistrationViewModel(
                get(),
                get()
        )
    }
}
