package com.example.monoproducts.Model

import com.google.gson.annotations.SerializedName

class Address (
    @SerializedName("fullname")
    val fullname: String,
    @SerializedName("tel")
    val tel: String,
    @SerializedName("province")
    val province: String,
    @SerializedName("district")
    val district: String,
    @SerializedName("zipcode")
    val zipcode: String,
    @SerializedName("detail")
    val detail: String
)