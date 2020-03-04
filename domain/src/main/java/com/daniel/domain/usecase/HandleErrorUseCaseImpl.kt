package com.daniel.domain.usecase

import androidx.lifecycle.LiveData
import com.daniel.domain.repository.TravelsRepository

class HandleErrorUseCaseImpl(
    private val travelsRepository: TravelsRepository
) : HandleErrorUseCase {
    override fun execute(): LiveData<Unit> = travelsRepository.getErrorLiveData()
}