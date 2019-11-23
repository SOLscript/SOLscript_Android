package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseTotalMoneyData(
    @SerializedName("message")
    val message: List<ResponseTotalMoneyDataMessage>,
    @SerializedName("totalMoney")
    val totalMoney: Int
)