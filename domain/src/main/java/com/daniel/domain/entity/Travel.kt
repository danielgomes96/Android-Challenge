package com.daniel.domain.entity

import java.io.Serializable

data class Travel(
    val title: String?,
    val price: Float?,
    val imageUrl: String?,
    val description: String?
) : Serializable