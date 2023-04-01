package com.example.translatorapp.ui.home

import androidx.annotation.StringRes

sealed class HomeUiState <out T:Any>{
    
    object Loading : HomeUiState<Nothing>()
    data class Success<out T:Any >(val data:T) : HomeUiState<T>()
    data class Error(@StringRes val message:Int) : HomeUiState<Nothing>()
}