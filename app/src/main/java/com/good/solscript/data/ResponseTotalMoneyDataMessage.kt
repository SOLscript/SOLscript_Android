package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseTotalMoneyDataMessage(
    @SerializedName("date")
    val date: String,
    @SerializedName("subList")
    val subList: List<ResponseTotalMoneyDataMessageSub>
)