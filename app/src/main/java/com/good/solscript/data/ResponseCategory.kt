package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseCategory(
    @SerializedName("data")
    val responseCategoryData: ResponseCategoryData,
    @SerializedName("responseTotalMoneyDataMessage")
    val message: String
)