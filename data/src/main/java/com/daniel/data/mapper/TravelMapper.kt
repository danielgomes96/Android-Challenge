package com.daniel.data.mapper

import com.daniel.data.dto.TravelDTO
import com.daniel.domain.entity.Travel

object TravelMapper {
    fun mapFrom(travelList: List<TravelDTO>): List<Travel> {
        val travels = ArrayList<Travel>()
        travelList.map {
            travels.add(
                Travel(it.title, it.price, it.imageUrl, it.description)
            )
        }
        return travels
    }
}