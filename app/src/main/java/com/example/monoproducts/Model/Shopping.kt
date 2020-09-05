package com.example.monoproducts.Model

import com.example.monoproduct.Model.Product
import com.google.gson.annotations.SerializedName

class Shopping (
    @SerializedName("product")
    val product: Product,
    @SerializedName("address")
    var address: Address,
    @SerializedName("cash")
    val cash: String,
    @SerializedName("unit")
    val unit: String
)