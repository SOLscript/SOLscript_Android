package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class CategoryData(
    @SerializedName("appname")
    val appname: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("isLike")
    val isLike: Boolean
)