package com.example.translatorapp.domain.usecase.detect

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.detect.response.DetectResponseItem
import com.example.translatorapp.data.dto.detect.post.PostDetectItem
import kotlinx.coroutines.flow.Flow

interface DetectLanguageUseCase {
    suspend operator fun invoke(post:List<PostDetectItem>): Flow<NetworkResponseState<List<DetectResponseItem>>>
}