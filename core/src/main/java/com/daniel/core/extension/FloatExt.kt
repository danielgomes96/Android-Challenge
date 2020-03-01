package com.daniel.core.extension

import java.text.NumberFormat
import java.util.*

fun Float.convertToCurrency(currencyCode: String): String {
    val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
    format.currency = Currency.getInstance(currencyCode)
    return format.format(this)
}