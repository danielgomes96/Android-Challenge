package com.daniel.data.di

import com.daniel.data.repository.TravelsRepositoryImpl
import com.daniel.domain.repository.TravelsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<TravelsRepository> {
        TravelsRepositoryImpl(
            get()
        )
    }
}