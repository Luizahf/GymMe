package com.gymme.app.modules

import com.gymme.app.ui.MyWorksheet.MyWorksheetViewModel
import com.gymme.app.ui.SplashScreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val UIModules = module {

    viewModel {
        SplashScreenViewModel(
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
}