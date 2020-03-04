package com.daniel.navigator

import android.content.Intent
import com.daniel.core.extension.loadIntentOrNull

object NavigatorImpl : Navigator {

    private const val TRAVEL_LIST = "com.daniel.travel_list.ui.TravelListActivity"
    private const val TRAVEL_DETAILS = "com.daniel.travel_details.TravelDetailsActivity"

    override fun openTravelDetailsIntent(): Intent? = TRAVEL_DETAILS.loadIntentOrNull()
    override fun openTravelListIntent(): Intent? = TRAVEL_LIST.loadIntentOrNull()
}
