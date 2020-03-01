package com.daniel.domain.usecase

import com.daniel.domain.entity.Travel
import com.github.kittinunf.result.coroutines.SuspendableResult

interface GetTravelListUseCase {
    suspend fun execute(): SuspendableResult<List<Travel>, Exception>
}