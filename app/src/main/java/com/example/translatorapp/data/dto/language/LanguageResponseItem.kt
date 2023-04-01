package com.example.translatorapp.data.dto.language


import com.google.gson.annotations.SerializedName

data class LanguageResponseItem(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
) {
    override fun toString(): String {
        return name.lowercase().replaceFirstChar(Char::uppercase)
    }
}