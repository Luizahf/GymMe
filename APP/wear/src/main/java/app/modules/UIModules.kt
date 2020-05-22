package com.gymme.app.modules

import com.gymme.app.ui.StartExercises.StartExercisesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val UIModules = module {

    viewModel {
        StartExercisesViewModel(
                get(),
                get()
        )
    }
}