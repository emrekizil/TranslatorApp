package com.example.translatorapp.data.repository

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.language.LanguageResponseItem
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
}