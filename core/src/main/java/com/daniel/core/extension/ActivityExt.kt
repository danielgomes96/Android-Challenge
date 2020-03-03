package com.daniel.core.extension

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes

fun <T : View> Activity.bind(@IdRes res: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy { findViewById<T>(res) }
}

fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}