package com.good.solscript.util

import android.view.View
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
fun setprice(view: TextView, price: Int) {
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

@BindingAdapter("price", "pay")
fun setPayInfo(view: TextView, price: Int, pay: String) {
    view.text = "월 " + price.toString() + "원 /" + pay
}

@BindingAdapter("plusBoolean", "plusPercent")
fun setPlusData(view: TextView, plusBoolean: Boolean, plusPercent: Int) {
    if (plusBoolean) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
        view.text = "+ " + plusPercent.toString() + " %"
    }
}

@BindingAdapter("minusBoolean", "minusPercent")
fun setMinusData(view: TextView, minusBoolean: Boolean, minusPercent: Int) {
    if (minusBoolean) {
        view.visibility = View.VISIBLE
        view.text = "- " + minusPercent.toString() + " %"
    } else {
        view.visibility = View.GONE
    }
}



