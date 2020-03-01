package com.daniel.data.repository

import com.daniel.data.TravelService
import com.daniel.data.mapper.TravelMapper
import com.daniel.domain.entity.Travel
import com.daniel.domain.repository.TravelsRepository
import com.github.kittinunf.result.coroutines.SuspendableResult

class TravelsRepositoryImpl(
    private val travelService: TravelService
) : TravelsRepository {

    override suspend fun getTravels(): SuspendableResult<List<Travel>, Exception> {
        return SuspendableResult.of {
            TravelMapper.mapFrom(travelService.getTravels())
        }
    }
}