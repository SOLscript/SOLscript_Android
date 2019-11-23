package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseRecommandData(
    @SerializedName("thr")
    val responseRecommandSubData: List<ResponseRecommandSubData>
)