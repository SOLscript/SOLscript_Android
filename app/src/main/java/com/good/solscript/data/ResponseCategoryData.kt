package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseCategoryData(
    @SerializedName("subData")
    val responseCategorySubData: List<ResponseCategorySubData>
)