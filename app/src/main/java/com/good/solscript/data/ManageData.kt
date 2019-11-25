package com.good.solscript.data

import com.google.gson.annotations.SerializedName

data class ManageData(
    @SerializedName("app_name")
    val appName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("pay")
    val pay: String,
    @SerializedName("isDecrease")
    val isDecrease: Boolean,
    @SerializedName("percent")
    val percent: Int

)