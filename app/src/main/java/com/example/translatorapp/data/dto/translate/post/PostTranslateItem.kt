package com.example.translatorapp.data.dto.translate.post


import com.google.gson.annotations.SerializedName

data class PostTranslateItem(
    @SerializedName("text")
    val text: String
)