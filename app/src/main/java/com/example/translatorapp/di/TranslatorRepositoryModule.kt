package com.example.translatorapp.di

import com.example.translatorapp.data.repository.TranslatorRepositoryImpl
import com.example.translatorapp.domain.repository.TranslatorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class TranslatorRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTranslatorRepositoryModule(translatorRepositoryImpl: TranslatorRepositoryImpl):TranslatorRepository
}