package com.daniel.domain.usecase

import androidx.lifecycle.LiveData
import com.daniel.domain.entity.Travel

interface GetTravelsUseCase {
    fun execute(): LiveData<List<Travel>>
}