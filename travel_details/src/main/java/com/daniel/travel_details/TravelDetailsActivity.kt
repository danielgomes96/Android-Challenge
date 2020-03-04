package com.daniel.travel_details

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.daniel.core.extension.bind
import com.daniel.core.extension.convertToCurrency
import com.daniel.core.extension.renderUrl
import com.daniel.core.extension.toast
import com.daniel.domain.entity.Travel

class TravelDetailsActivity : AppCompatActivity() {

    companion object {
        const val INTENT_KEY_TRAVEL = "KEY_TRAVEL"
        private const val CURRENCY_CODE = "BRL"
    }

    private val tvTitle by bind<TextView>(R.id.activity_travel_details_title)
    private val tvPrice by bind<TextView>(R.id.activity_travel_details_price)
    private val tvDescription by bind<TextView>(R.id.activity_travel_details_description)
    private val btnBuy by bind<Button>(R.id.activity_travel_details_btn_buy)
    private val imImage by bind<ImageView>(R.id.activity_travel_details_image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val travel = intent.getSerializableExtra(INTENT_KEY_TRAVEL) as Travel
        setupDetails(travel)
    }

    private fun setupDetails(travel: Travel) {
        supportActionBar?.title = travel.title
        tvTitle.text = travel.title
        tvDescription.text = travel.description
        tvPrice.text = travel.price?.convertToCurrency(CURRENCY_CODE)
        travel.imageUrl?.let { imageUrl ->
            imImage.renderUrl(this, imageUrl)
        }
        btnBuy.setOnClickListener {
            toast(getString(R.string.btn_buy_toast_message))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}