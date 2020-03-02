package com.daniel.viajabessa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent().setClassName(this, "com.daniel.travel_list.ui.TravelListActivity")
        startActivity(intent)
        finish()
    }
}
