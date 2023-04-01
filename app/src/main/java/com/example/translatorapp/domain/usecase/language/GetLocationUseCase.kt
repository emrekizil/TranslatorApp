package com.example.translatorapp.domain.usecase.language

import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.language.LanguageResponseItem
import kotlinx.coroutines.flow.Flow

interface GetLocationUseCase {
    suspend operator fun invoke() : Flow<NetworkResponseState<List<LanguageResponseItem>>>

}