package com.example.translatorapp.di

import com.example.translatorapp.data.api.LanguageApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Provides
    @ViewModelScoped
    fun provideLanguageApi() : LanguageApi{
        return Retrofit.Builder()
            .baseUrl("https://ws.detectlanguage.com/0.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LanguageApi::class.java)
    }
}