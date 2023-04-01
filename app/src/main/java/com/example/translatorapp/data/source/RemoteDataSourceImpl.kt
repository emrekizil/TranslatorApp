package com.example.translatorapp.data.source

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.api.LanguageApi
import com.example.translatorapp.data.dto.language.LanguageResponseItem
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val languageApi: LanguageApi
) : RemoteDataSource {

    override suspend fun getLocations(): NetworkResponseState<List<LanguageResponseItem>> =
        try {
            val response = languageApi.getLanguages()
            NetworkResponseState.Success(response)
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }

}