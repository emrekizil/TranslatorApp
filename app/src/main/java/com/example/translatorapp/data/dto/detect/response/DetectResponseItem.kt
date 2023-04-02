package com.example.translatorapp.data.dto.detect.response


import com.google.gson.annotations.SerializedName

data class DetectResponseItem(
    @SerializedName("isTranslationSupported")
    val isTranslationSupported: Boolean,
    @SerializedName("isTransliterationSupported")
    val isTransliterationSupported: Boolean,
    @SerializedName("language")
    val language: String,
    @SerializedName("score")
    val score: Double
)