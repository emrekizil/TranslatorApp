package com.example.translatorapp.data.api

import com.example.translatorapp.data.dto.language.LanguageResponse
import retrofit2.http.GET

interface LanguageApi {
    @GET("/languages")
    suspend fun getLanguages(): LanguageResponse

}