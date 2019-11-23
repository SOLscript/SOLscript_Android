package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseCategorySubData(
    @SerializedName("category")
    val category: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("feat")
    val feat: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("images")
    val images: List<Any>,
    @SerializedName("like")
    val like: Boolean,
    @SerializedName("likeCount")
    val likeCount: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("_somethingElse")
    val somethingElse: Int,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)