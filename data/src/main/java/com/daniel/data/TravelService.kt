package com.daniel.data

import com.daniel.data.dto.TravelDTO
import retrofit2.http.GET

interface TravelService {
    @GET("travels")
    suspend fun getTravels(): List<TravelDTO>
}