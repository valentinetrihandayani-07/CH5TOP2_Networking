package com.valentine.networkingsample.model


import com.google.gson.annotations.SerializedName

data class RegisterResponseItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id:Int,
    @SerializedName("role")
    val role: String,
    @SerializedName("updateAt")
    val updateAt: String
)