package com.example.translatorapp.data.dto.translate.response


import com.google.gson.annotations.SerializedName

data class Translation(
    @SerializedName("text")
    val text: String,
    @SerializedName("to")
    val to: String
)