package com.daniel.navigator

import android.content.Intent

interface Navigator {
    fun openTravelDetailsIntent(): Intent?
    fun openTravelListIntent(): Intent?
}