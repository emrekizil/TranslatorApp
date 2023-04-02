package com.example.translatorapp.data.source

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.detect.response.DetectResponseItem
import com.example.translatorapp.data.dto.detect.post.PostDetectItem
import com.example.translatorapp.data.dto.language.LanguageResponseItem
import com.example.translatorapp.data.dto.translate.response.TranslateResponseItem
import com.example.translatorapp.data.dto.translate.post.PostTranslateItem

interface RemoteDataSource {
    suspend fun getLocations() : NetworkResponseState<List<LanguageResponseItem>>

    suspend fun pushTranslate(post:List<PostTranslateItem>,from: String,to: String) : NetworkResponseState<List<TranslateResponseItem>>

    suspend fun detectLanguage(post:List<PostDetectItem>) : NetworkResponseState<List<DetectResponseItem>>
}