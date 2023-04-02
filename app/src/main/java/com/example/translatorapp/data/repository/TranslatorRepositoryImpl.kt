package com.example.translatorapp.data.repository

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.detect.response.DetectResponseItem
import com.example.translatorapp.data.dto.detect.post.PostDetectItem
import com.example.translatorapp.data.dto.language.LanguageResponseItem
import com.example.translatorapp.data.dto.translate.response.TranslateResponseItem
import com.example.translatorapp.data.dto.translate.post.PostTranslateItem
import com.example.translatorapp.data.source.RemoteDataSource
import com.example.translatorapp.di.IoDispatcher
import com.example.translatorapp.domain.repository.TranslatorRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TranslatorRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : TranslatorRepository {
    override suspend fun getLocations(): NetworkResponseState<List<LanguageResponseItem>> =
        withContext(ioDispatcher){
            try {
                remoteDataSource.getLocations()
            }catch (e:Exception){
                NetworkResponseState.Error(e)
            }
        }

    override suspend fun pushTranslate(
        post: List<PostTranslateItem>,
        from: String,
        to: String
    ): NetworkResponseState<List<TranslateResponseItem>> =
        withContext(ioDispatcher){
            try {
                remoteDataSource.pushTranslate(post,from,to)
            }catch (e:Exception){
                NetworkResponseState.Error(e)
            }
        }

    override suspend fun detectLanguage(post: List<PostDetectItem>): NetworkResponseState<List<DetectResponseItem>> =
        withContext(ioDispatcher){
            try {
                remoteDataSource.detectLanguage(post)
            }catch (e:Exception){
                NetworkResponseState.Error(e)
            }
        }



}