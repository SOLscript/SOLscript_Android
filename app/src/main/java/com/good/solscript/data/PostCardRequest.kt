package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class PostCardRequest(
    @SerializedName("cardNoEnc")
    val cardNoEnc: String,
    @SerializedName("cvv2")
    val cvv2: String,
    @SerializedName("passwd")
    val passwd: String,
    @SerializedName("validTrm")
    val validTrm: String
)