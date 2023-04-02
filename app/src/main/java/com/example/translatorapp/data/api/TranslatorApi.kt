package com.example.translatorapp.data.api

import com.example.translatorapp.BuildConfig.API_KEY
import com.example.translatorapp.BuildConfig.LOCATION
import com.example.translatorapp.data.dto.detect.response.DetectResponse
import com.example.translatorapp.data.dto.detect.post.PostDetectItem
import com.example.translatorapp.data.dto.translate.response.TranslateResponse
import com.example.translatorapp.data.dto.translate.post.PostTranslateItem
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslatorApi {

    @Headers(
        "Ocp-Apim-Subscription-Key: $API_KEY",
        "Ocp-Apim-Subscription-Region: $LOCATION",
        "Content-type: application/json"
    )
    @POST("translate")
    suspend fun pushTranslate(
        @Body post: List<PostTranslateItem>,
        @Query("api-version") api_version: String = "3.0",
        @Query("from") from: String,
        @Query("to") to: String
    ): TranslateResponse

    @Headers(
        "Ocp-Apim-Subscription-Key: $API_KEY",
        "Ocp-Apim-Subscription-Region: $LOCATION",
        "Content-type: application/json"
    )
    @POST("detect")
    suspend fun detectLanguage(
        @Body post: List<PostDetectItem>,
        @Query("api-version") api_version: String = "3.0"
    ) : DetectResponse

}