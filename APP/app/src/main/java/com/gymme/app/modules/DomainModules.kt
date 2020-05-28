package com.gymme.app.modules

import com.gymme.domain.handlers.*
import org.koin.dsl.module

internal val DomainModules = module {
    factory { WorksheetExercisesHandler(repository = get()) }
    factory { UserHandler(repository = get()) }
    factory { PracticeHandler(repository = get()) }
    factory { PracticeWorksheetsHandler(repository = get()) }
    factory { MetricsHandler(repository = get()) }
}