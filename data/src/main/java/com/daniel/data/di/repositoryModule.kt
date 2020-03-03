package com.daniel.data.di

import androidx.room.Room
import com.daniel.data.database.TravelsDatabase
import com.daniel.data.repository.TravelsRepositoryImpl
import com.daniel.domain.repository.TravelsRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val TRAVEL_DATABASE = "db_travel"

val repositoryModule = module {
    factory<TravelsRepository> {
        TravelsRepositoryImpl(
            get(),
            get()
        )
    }

    single {
        Room.databaseBuilder(androidContext(), TravelsDatabase::class.java, TRAVEL_DATABASE)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<TravelsDatabase>().travelDao()
    }

}