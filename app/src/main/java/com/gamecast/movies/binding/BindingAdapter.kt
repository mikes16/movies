package com.gamecast.movies.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.gamecast.movies.BuildConfig

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context)
        .load("${BuildConfig.IMAGE_BASE_URL}original$url")
        .centerCrop()
        .dontAnimate()
        .into(view)
}