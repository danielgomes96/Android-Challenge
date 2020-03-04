package com.daniel.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.daniel.data.TravelService
import com.daniel.data.database.TravelsDao
import com.daniel.data.dto.TravelDTO
import com.daniel.data.mapper.TravelMapper
import com.daniel.domain.entity.Travel
import com.daniel.domain.repository.TravelsRepository
import com.github.kittinunf.result.coroutines.SuspendableResult
import java.lang.Exception

class TravelsRepositoryImpl(
    private val travelService: TravelService,
    private val travelsDao: TravelsDao
) : TravelsRepository {

    private val errorLiveData = MutableLiveData<Unit>()
    override fun getErrorLiveData(): LiveData<Unit> = errorLiveData
    override fun getTravelsFromDatabase(): LiveData<List<Travel>> = travelsDao.getAllTravels()

    override suspend fun fetchTravels() {
        when(
            val travelsDto = SuspendableResult.of<List<TravelDTO>, Exception> {
            (travelService.getTravels())
        }) {
            is SuspendableResult.Success -> {
                travelsDao.insertTravels(TravelMapper.mapFrom(travelsDto.value))
            }
            is SuspendableResult.Failure -> {
                errorLiveData.postValue(Unit)
            }
        }
    }
}