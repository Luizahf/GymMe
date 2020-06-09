package com.gymme.app.modules

import androidx.room.Room
import com.gymme.data.api.GymMeApi
import com.gymme.data.api.base.RetrofitConfig
import com.gymme.data.dao.AppDatabase
import com.gymme.data.repositories.*
import com.gymme.domain.repositories.*
import org.koin.dsl.bind
import org.koin.dsl.module

internal val DataModules = module {
    single {
        RetrofitConfig.createService(GymMeApi::class.java)
    }

    single {
        Room.databaseBuilder(
                get(),
                AppDatabase::class.java,
                "gymme_db")
                .build()
    }

    single { get<AppDatabase>().worksheetExercisesDao() }
    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().metricsDao() }

    factory { WorksheetExercisesRepository(get(), get()) } bind IWorksheetExercisesRepository::class
    factory { UserRepository(get(), get()) } bind IUserRepository::class
    factory { PracticeRepository(get()) } bind IPracticeRepository::class
    factory { PracticeWorksheetsRepository(get()) } bind IPracticeWorksheetseRepository::class
    factory { MetricsRepository(get(), get()) } bind IMetricsRepository::class
    factory { LoginRepository(get()) } bind ILoginRepository::class
}