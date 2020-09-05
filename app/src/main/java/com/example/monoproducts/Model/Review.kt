package com.example.monoproduct.Model

import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("userID")
    val userID: String,
    @SerializedName("rate")
    val rate: Int,
    @SerializedName("reviewInfo")
    val reviewInfo: String
)