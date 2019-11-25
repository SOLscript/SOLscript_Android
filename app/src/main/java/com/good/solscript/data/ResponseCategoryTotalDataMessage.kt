package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseCategoryTotalDataMessage(
    @SerializedName("category")
    val category: String,
    @SerializedName("price")
    val price: Int
)