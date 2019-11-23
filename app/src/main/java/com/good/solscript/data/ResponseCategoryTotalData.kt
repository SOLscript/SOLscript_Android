package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseCategoryTotalData(
    @SerializedName("message")
    val message: List<ResponseCategoryTotalDataMessage>,
    @SerializedName("totalPrice")
    val totalPrice: Int
)