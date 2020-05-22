package com.gymme.app.modules

import com.gymme.domain.handlers.WorksheetExercisesHandler
import org.koin.dsl.module

internal val DomainModules = module {
    factory { WorksheetExercisesHandler(repository = get()) }
}