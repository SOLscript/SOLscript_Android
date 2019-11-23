package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class DataHeader(
    @SerializedName("reqKey")
    val reqKey: Any,
    @SerializedName("resultCode")
    val resultCode: String,
    @SerializedName("resultMessage")
    val resultMessage: String,
    @SerializedName("successCode")
    val successCode: String
)