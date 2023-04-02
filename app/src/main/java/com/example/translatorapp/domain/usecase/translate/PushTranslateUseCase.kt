package com.example.translatorapp.domain.usecase.translate

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.translate.response.TranslateResponseItem
import com.example.translatorapp.data.dto.translate.post.PostTranslateItem
import kotlinx.coroutines.flow.Flow

interface PushTranslateUseCase {
    suspend operator fun invoke(post:List<PostTranslateItem>, from: String, to: String) :
            Flow<NetworkResponseState<List<TranslateResponseItem>>>
}