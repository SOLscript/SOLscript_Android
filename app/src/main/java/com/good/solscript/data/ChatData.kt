package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ChatData(
    @SerializedName("response")
    val response: String,
    @SerializedName("id")
    val id: String
)