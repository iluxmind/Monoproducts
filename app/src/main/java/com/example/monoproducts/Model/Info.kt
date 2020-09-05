package com.example.monoproduct.Model

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("brand")
    val brand: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("series")
    val series: String
)