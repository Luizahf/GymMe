package com.gymme.app.modules

import androidx.room.Room
import com.gymme.data.api.GymMeApi
import com.gymme.data.api.base.RetrofitConfig
import com.gymme.data.dao.AppDatabase
import com.gymme.data.repositories.WorksheetExercisesRepository
import com.gymme.domain.repositories.IWorksheetExercisesRepository
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

    single {
        get<AppDatabase>().worksheetExercisesDao()
        get<AppDatabase>().userDao()
    }

    factory { WorksheetExercisesRepository(get(), get()) } bind IWorksheetExercisesRepository::class
}