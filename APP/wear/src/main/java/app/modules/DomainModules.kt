package com.gymme.app.modules

import com.gymme.domain.handlers.PracticeHandler
import com.gymme.domain.handlers.PracticeWorksheetsHandler
import com.gymme.domain.handlers.UserHandler
import com.gymme.domain.handlers.WorksheetExercisesHandler
import org.koin.dsl.module

internal val DomainModules = module {
  factory { WorksheetExercisesHandler(repository = get()) }
  factory { UserHandler(repository = get()) }
  factory { PracticeHandler(repository = get()) }
  factory { PracticeWorksheetsHandler(repository = get()) }
}