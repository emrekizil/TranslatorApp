package com.example.translatorapp.data.dto.translate.response


import com.google.gson.annotations.SerializedName

data class TranslateResponseItem(
    @SerializedName("translations")
    val translations: List<Translation>
)