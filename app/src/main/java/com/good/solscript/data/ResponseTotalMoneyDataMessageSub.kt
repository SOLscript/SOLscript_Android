package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseTotalMoneyDataMessageSub(
    @SerializedName("category")
    val category: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)