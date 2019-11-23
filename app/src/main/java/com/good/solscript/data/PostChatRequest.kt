package com.good.solscript.data

import com.google.gson.annotations.SerializedName

data class PostChatRequest(
    @SerializedName("queryTxt")
    val queryTxt: String,
    @SerializedName("sessionId")
    val sessionId: String
)