package com.daniel.travel_list.ui

import androidx.lifecycle.MutableLiveData
import com.daniel.core.base.BaseViewModel
import com.daniel.domain.entity.Travel
import com.daniel.domain.usecase.GetTravelListUseCase
import com.github.kittinunf.result.coroutines.SuspendableResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TravelListViewModel(
    private val getTravelListUseCase: GetTravelListUseCase
) : BaseViewModel() {

    val travelListLiveData = MutableLiveData<List<Travel>>()

    fun getTravelList() {
        loadingLiveData.postValue(true)
        CoroutineScope(coroutineContext).launch {
            when (val travelList = getTravelListUseCase.execute()) {
                is SuspendableResult.Success -> {
                    loadingLiveData.postValue(false)
                    travelListLiveData.postValue(travelList.value)
                }
                is SuspendableResult.Failure -> {
                    loadingLiveData.postValue(false)
                }
            }
        }
    }
}