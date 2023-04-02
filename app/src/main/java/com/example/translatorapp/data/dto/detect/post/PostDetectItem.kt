package com.example.translatorapp.data.dto.detect.post


import com.google.gson.annotations.SerializedName

data class PostDetectItem(
    @SerializedName("text")
    val text: String
)