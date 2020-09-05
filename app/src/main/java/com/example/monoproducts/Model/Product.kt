package com.example.monoproduct.Model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("productID")
    val productID: String,
    @SerializedName("productName")
    val productName: String,
    @SerializedName("productPrice")
    val productPrice: Double,
    @SerializedName("productImg")
    val productImg: String,
    @SerializedName("Stock")
    val Stock: Int,
    @SerializedName("info")
    val info: Info,
    @SerializedName("review")
    val review: List<Review>
)