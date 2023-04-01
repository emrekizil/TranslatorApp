package com.example.translatorapp.domain.repository

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.language.LanguageResponseItem

interface TranslatorRepository {
    suspend fun getLocations(): NetworkResponseState<List<LanguageResponseItem>>
}