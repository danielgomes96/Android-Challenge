package com.daniel.domain.repository

import com.daniel.domain.entity.Travel
import com.github.kittinunf.result.coroutines.SuspendableResult

interface TravelsRepository {
    suspend fun getTravels(): SuspendableResult<List<Travel>, Exception>
}