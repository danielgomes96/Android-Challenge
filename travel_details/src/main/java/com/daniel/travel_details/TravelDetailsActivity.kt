package com.daniel.travel_details

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.daniel.core.extension.bind
import com.daniel.core.extension.convertToCurrency
import com.daniel.core.extension.renderUrl
import com.daniel.domain.entity.Travel

class TravelDetailsActivity : AppCompatActivity() {

    companion object {
        const val INTENT_KEY_TRAVEL = "KEY_TRAVEL"
    }

    private val tvTitle by bind<TextView>(R.id.activity_travel_details_title)
    private val tvPrice by bind<TextView>(R.id.activity_travel_details_price)
    private val tvDescription by bind<TextView>(R.id.activity_travel_details_description)
    private val btnBuy by bind<Button>(R.id.activity_travel_details_btn_buy)
    private val imImage by bind<ImageView>(R.id.activity_travel_details_image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_details)

        val travel = intent.getSerializableExtra(INTENT_KEY_TRAVEL) as Travel
        setupDetails(travel)
    }

    private fun setupDetails(travel: Travel) {
        tvTitle.text = travel.title
        tvDescription.text = travel.description
        tvPrice.text = travel.price?.convertToCurrency("BRL")
        travel.imageUrl?.let { imageUrl ->
            imImage.renderUrl(this, imageUrl)
        }
    }
}