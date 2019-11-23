package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseCategorySubData(
    @SerializedName("imgURL")
    val imgURL: String,
    @SerializedName("like")
    val like: Boolean,
    @SerializedName("likeCount")
    val likeCount: Int,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("title")
    val title: String
)