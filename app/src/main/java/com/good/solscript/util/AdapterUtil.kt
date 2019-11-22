package com.good.solscript.util

import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImage")
fun setImageUrl(view: ImageView, profile: String) {

    Glide.with(view.context)
        .load(profile)
        .into(view)
}

@BindingAdapter("setProgress")
fun setProgressFrot(view: SeekBar, percent: Float) {
    view.progress = percent.toInt()
}

@BindingAdapter("setPercent")
fun setPercent(view: TextView, percent: Float) {
    view.text = percent.toString() + "%"
}