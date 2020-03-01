package com.daniel.domain.di

import com.daniel.domain.repository.TravelsRepository
import com.daniel.domain.usecase.GetTravelListUseCase
import com.daniel.domain.usecase.GetTravelListUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetTravelListUseCaseImpl(get<TravelsRepository>()) as GetTravelListUseCase
    }
}