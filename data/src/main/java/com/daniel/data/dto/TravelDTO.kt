package com.daniel.data.dto

import com.google.gson.annotations.SerializedName

data class TravelDTO(
    @SerializedName("title") val title: String?,
    @SerializedName("price") val price: Float?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("description") val description: String?
)