package com.daniel.domain.di

import com.daniel.domain.repository.TravelsRepository
import com.daniel.domain.usecase.FetchTravelsUseCase
import com.daniel.domain.usecase.FetchTravelsUseCaseImpl
import com.daniel.domain.usecase.GetTravelsUseCase
import com.daniel.domain.usecase.GetTravelsUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory {
        FetchTravelsUseCaseImpl(get<TravelsRepository>()) as FetchTravelsUseCase
    }
    factory {
        GetTravelsUseCaseImpl(get<TravelsRepository>()) as GetTravelsUseCase
    }
}