package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseRecommandSubData(
    @SerializedName("_id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("title")
    val title: String
)