package com.daniel.core.extension

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.renderUrl(context: Context, url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)
}
