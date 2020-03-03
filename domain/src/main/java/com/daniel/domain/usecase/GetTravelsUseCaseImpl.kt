package com.daniel.domain.usecase

import com.daniel.domain.repository.TravelsRepository

class GetTravelsUseCaseImpl(
    private val travelsRepository: TravelsRepository
) : GetTravelsUseCase {
    override fun execute() = travelsRepository.getTravelsFromDatabase()
}