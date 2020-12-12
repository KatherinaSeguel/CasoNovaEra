package com.example.casonovaera.model.pojo


import com.google.gson.annotations.SerializedName

data class productosItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)