package com.daniel.travel_list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.daniel.core.base.BaseViewModel
import com.daniel.domain.entity.Travel
import com.daniel.domain.usecase.FetchTravelsUseCase
import com.daniel.domain.usecase.GetTravelsUseCase
import com.daniel.domain.usecase.HandleErrorUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TravelListViewModel(
    private val fetchTravelsUseCase: FetchTravelsUseCase,
    private val getTravelsUseCase: GetTravelsUseCase,
    private val handleErrorUseCase: HandleErrorUseCase
) : BaseViewModel() {

    fun travelsLiveData(): LiveData<List<Travel>> = getTravelsUseCase.execute()
    fun errorLiveData(): LiveData<Unit> = handleErrorUseCase.execute()

    fun fetchTravels() {
        CoroutineScope(coroutineContext).launch {
            fetchTravelsUseCase.execute()
        }
    }

}