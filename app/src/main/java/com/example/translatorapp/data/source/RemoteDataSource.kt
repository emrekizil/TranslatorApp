package com.example.translatorapp.data.source

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.language.LanguageResponseItem

interface RemoteDataSource {
    suspend fun getLocations() : NetworkResponseState<List<LanguageResponseItem>>
}