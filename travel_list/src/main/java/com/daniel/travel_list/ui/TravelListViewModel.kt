package com.daniel.travel_list.ui

import androidx.lifecycle.LiveData
import com.daniel.core.base.BaseViewModel
import com.daniel.domain.entity.Travel
import com.daniel.domain.usecase.FetchTravelsUseCase
import com.daniel.domain.usecase.GetTravelsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TravelListViewModel(
    private val fetchTravelsUseCase: FetchTravelsUseCase,
    private val getTravelsUseCase: GetTravelsUseCase
) : BaseViewModel() {

    fun travelsLiveData(): LiveData<List<Travel>> = getTravelsUseCase.execute()

    fun fetchTravels() {
        CoroutineScope(coroutineContext).launch {
            fetchTravelsUseCase.execute()
        }
    }

}