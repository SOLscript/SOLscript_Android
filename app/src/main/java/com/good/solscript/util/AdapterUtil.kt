package com.good.solscript.util

import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("setCircleImg")
fun setCircleImageUrl(view: ImageView, profile: String) {
    Glide.with(view.context)
        .load(profile)
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}

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

@BindingAdapter("price")
fun setPayInfo(view: TextView, price: Int) {
    view.text = price.toString() + "/"
}

@BindingAdapter("setPayDay")
fun setPayDay(view: TextView, pay: String) {
    view.text = pay
    //데이터보고.. 그때 편집하자..
}

@BindingAdapter("setRcoudCornerImage")
fun setRcoudCornerImage(view: ImageView, profile: String) {
    Glide.with(view.context)
        .load(profile)
        .transform(RoundedCorners(18))
        // Alternative: .transforms(CenterCrop(), RoundedCorners(radius))
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}
