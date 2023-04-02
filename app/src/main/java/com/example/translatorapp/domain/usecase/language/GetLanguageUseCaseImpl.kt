package com.example.translatorapp.domain.usecase.language

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.language.LanguageResponseItem
import com.example.translatorapp.domain.repository.TranslatorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLanguageUseCaseImpl @Inject constructor(
    private val repository: TranslatorRepository
        ) : GetLanguageUseCase {
    override suspend fun invoke(): Flow<NetworkResponseState<List<LanguageResponseItem>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = repository.getLocations()){
                is NetworkResponseState.Error-> emit(response)
                NetworkResponseState.Loading->Unit
                is NetworkResponseState.Success -> emit(
                    NetworkResponseState.Success(response.result)
                )
            }
        }
}