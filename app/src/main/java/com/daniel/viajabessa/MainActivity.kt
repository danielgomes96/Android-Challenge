package com.daniel.viajabessa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.daniel.navigator.Navigator
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navigator by inject<Navigator>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = navigator.openTravelListIntent()
        startActivity(intent)
        finish()
    }
}
