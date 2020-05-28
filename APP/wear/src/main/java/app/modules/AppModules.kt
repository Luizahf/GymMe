package com.gymme.app.modules

import org.koin.core.module.Module


object AppModules {
  fun getModules(): List<Module> = listOf(
          DataModules,
          DomainModules,
          UIModules
  )
}