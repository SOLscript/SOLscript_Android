package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseRecommand(
    @SerializedName("data")
    val responseRecommandData: ResponseRecommandData,
    @SerializedName("message")
    val message: String
)