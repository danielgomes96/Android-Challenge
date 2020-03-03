package com.daniel.domain.repository

import androidx.lifecycle.LiveData
import com.daniel.domain.entity.Travel

interface TravelsRepository {
    suspend fun fetchTravels()
    fun getTravelsFromDatabase(): LiveData<List<Travel>>
}