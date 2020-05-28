package com.gymme.app

import android.app.Application
import com.gymme.app.modules.AppModules
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class GymMeApp : Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidContext(this@GymMeApp)
      modules(
              AppModules.getModules()
      )
    }
  }
}