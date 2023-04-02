package com.example.translatorapp.domain.usecase.detect

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.detect.response.DetectResponseItem
import com.example.translatorapp.data.dto.detect.post.PostDetectItem
import com.example.translatorapp.domain.repository.TranslatorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetectLanguageUseCaseImpl @Inject constructor(
    private val repository: TranslatorRepository
) : DetectLanguageUseCase {
    override suspend fun invoke(post: List<PostDetectItem>): Flow<NetworkResponseState<List<DetectResponseItem>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = repository.detectLanguage(post)){
                NetworkResponseState.Loading -> Unit
                is NetworkResponseState.Error -> emit(response)
                is NetworkResponseState.Success -> emit(NetworkResponseState.Success(response.result))
            }
        }

}