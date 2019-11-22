package com.good.solscript.data

import com.google.gson.annotations.SerializedName

data class SubscriptData(
    @SerializedName("img")
    val img: String,
    @SerializedName("appname")
    val appname: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("pay")
    val pay: String,
    @SerializedName("prev")
    val prev: String,
    @SerializedName("next")
    val next: String
)