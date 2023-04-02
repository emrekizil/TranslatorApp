package com.example.translatorapp.di

import com.example.translatorapp.domain.usecase.detect.DetectLanguageUseCase
import com.example.translatorapp.domain.usecase.detect.DetectLanguageUseCaseImpl
import com.example.translatorapp.domain.usecase.language.GetLanguageUseCase
import com.example.translatorapp.domain.usecase.language.GetLanguageUseCaseImpl
import com.example.translatorapp.domain.usecase.translate.PushTranslateUseCase
import com.example.translatorapp.domain.usecase.translate.PushTranslateUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetLanguageUseCase(getLanguageUseCaseImpl: GetLanguageUseCaseImpl):GetLanguageUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindPushTranslateUseCase(pushTranslateUseCaseImpl: PushTranslateUseCaseImpl):PushTranslateUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDetectLanguageUseCase(detectLanguageUseCaseImpl: DetectLanguageUseCaseImpl):DetectLanguageUseCase
}