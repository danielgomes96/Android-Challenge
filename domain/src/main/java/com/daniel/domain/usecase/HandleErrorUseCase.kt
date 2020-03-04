package com.daniel.domain.usecase

import androidx.lifecycle.LiveData

interface HandleErrorUseCase {
    fun execute(): LiveData<Unit>
}