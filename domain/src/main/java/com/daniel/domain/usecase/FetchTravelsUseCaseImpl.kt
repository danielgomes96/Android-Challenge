package com.daniel.domain.usecase

import com.daniel.domain.repository.TravelsRepository

class FetchTravelsUseCaseImpl(
    private val travelsRepository: TravelsRepository
) : FetchTravelsUseCase {
    override suspend fun execute() = travelsRepository.fetchTravels()
}