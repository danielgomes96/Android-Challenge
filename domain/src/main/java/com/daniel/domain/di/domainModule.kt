package com.daniel.domain.di

import com.daniel.domain.repository.TravelsRepository
import com.daniel.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {
    factory {
        FetchTravelsUseCaseImpl(get<TravelsRepository>()) as FetchTravelsUseCase
    }
    factory {
        GetTravelsUseCaseImpl(get<TravelsRepository>()) as GetTravelsUseCase
    }
    factory {
        HandleErrorUseCaseImpl(get<TravelsRepository>()) as HandleErrorUseCase
    }
}