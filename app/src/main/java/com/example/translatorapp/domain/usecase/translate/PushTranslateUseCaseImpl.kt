package com.example.translatorapp.domain.usecase.translate

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.translate.response.TranslateResponseItem
import com.example.translatorapp.data.dto.translate.post.PostTranslateItem
import com.example.translatorapp.domain.repository.TranslatorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class PushTranslateUseCaseImpl @Inject constructor(
    private val repository: TranslatorRepository
) : PushTranslateUseCase {
    override suspend fun invoke(
        post: List<PostTranslateItem>,
        from: String,
        to: String
    ): Flow<NetworkResponseState<List<TranslateResponseItem>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = repository.pushTranslate(post,from,to)){
                NetworkResponseState.Loading -> Unit
                is NetworkResponseState.Error -> emit(response)
                is NetworkResponseState.Success -> emit(NetworkResponseState.Success(response.result))
            }
        }


}