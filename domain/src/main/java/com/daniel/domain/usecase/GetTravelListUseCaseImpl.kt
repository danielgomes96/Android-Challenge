package com.daniel.domain.usecase

import com.daniel.domain.entity.Travel
import com.daniel.domain.repository.TravelsRepository
import com.github.kittinunf.result.coroutines.SuspendableResult

class GetTravelListUseCaseImpl(
    private val travelsRepository: TravelsRepository
) : GetTravelListUseCase {
    override suspend fun execute(): SuspendableResult<List<Travel>, Exception> =
        travelsRepository.getTravels()
}