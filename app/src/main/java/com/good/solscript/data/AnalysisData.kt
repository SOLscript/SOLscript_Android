package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class AnalysisData(
    @SerializedName("category")
    val category: String,
    @SerializedName("money")
    val money: String,
    @SerializedName("percent")
    val percent: Float
)