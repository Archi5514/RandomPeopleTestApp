package com.example.randompeopletestapp.data.image

import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImage(url: String?, imageView: ImageView) {
    Glide.with(imageView)
        .load(url)
        .into(imageView)
}