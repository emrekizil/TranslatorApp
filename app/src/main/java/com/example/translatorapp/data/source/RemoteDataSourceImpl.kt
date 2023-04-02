package com.example.translatorapp.data.source

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.api.LanguageApi
import com.example.translatorapp.data.api.TranslatorApi
import com.example.translatorapp.data.dto.detect.response.DetectResponseItem
import com.example.translatorapp.data.dto.detect.post.PostDetectItem
import com.example.translatorapp.data.dto.language.LanguageResponseItem
import com.example.translatorapp.data.dto.translate.response.TranslateResponseItem
import com.example.translatorapp.data.dto.translate.post.PostTranslateItem
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val languageApi: LanguageApi,
    private val translatorApi: TranslatorApi
) : RemoteDataSource {

    override suspend fun getLocations(): NetworkResponseState<List<LanguageResponseItem>> =
        try {
            val response = languageApi.getLanguages()
            NetworkResponseState.Success(response)
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }

    override suspend fun pushTranslate(
        post: List<PostTranslateItem>,
        from: String,
        to: String
    ): NetworkResponseState<List<TranslateResponseItem>> =
        try {
            val response = translatorApi.pushTranslate(post,"3.0",from,to)
            NetworkResponseState.Success(response)
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }

    override suspend fun detectLanguage(post: List<PostDetectItem>): NetworkResponseState<List<DetectResponseItem>> =
        try {
            val response = translatorApi.detectLanguage(post)
            NetworkResponseState.Success(response)
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }

}