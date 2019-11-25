package com.good.solscript.data


import com.google.gson.annotations.SerializedName

data class ResponseRegisterCard(
    @SerializedName("dataBody")
    val dataBody: DataBody,
    @SerializedName("dataHeader")
    val dataHeader: DataHeader
)