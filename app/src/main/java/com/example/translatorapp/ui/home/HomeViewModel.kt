package com.example.translatorapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translatorapp.R
import com.example.translatorapp.data.NetworkResponseState
import com.example.translatorapp.data.dto.detect.response.DetectResponseItem
import com.example.translatorapp.data.dto.detect.post.PostDetectItem
import com.example.translatorapp.data.dto.language.LanguageResponseItem
import com.example.translatorapp.data.dto.translate.response.TranslateResponseItem
import com.example.translatorapp.data.dto.translate.post.PostTranslateItem
import com.example.translatorapp.domain.usecase.detect.DetectLanguageUseCase
import com.example.translatorapp.domain.usecase.language.GetLanguageUseCase
import com.example.translatorapp.domain.usecase.translate.PushTranslateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLanguageUseCase : GetLanguageUseCase,
    private val pushTranslateUseCase: PushTranslateUseCase,
    private val detectLanguageUseCase: DetectLanguageUseCase
) : ViewModel() {

    private var _languageHomeUiState = MutableLiveData<HomeUiState<LanguageResponseItem>>()
    val languageHomeUiState : LiveData<HomeUiState<LanguageResponseItem>> get() = _languageHomeUiState

    private var _translateHomeUiState = MutableLiveData<HomeUiState<TranslateResponseItem>>()
    val translateHomeUiState : LiveData<HomeUiState<TranslateResponseItem>> get() = _translateHomeUiState

    private var _detectLanguageHomeUiState = MutableLiveData<HomeUiState<DetectResponseItem>>()
    val detectLanguageHomeUiState :LiveData<HomeUiState<DetectResponseItem>> get() = _detectLanguageHomeUiState

    var fromLanguage = ""
    var toLanguage = ""
    fun getLanguage(){
        viewModelScope.launch {
            getLanguageUseCase.invoke().collectLatest {
                when(it){
                    is NetworkResponseState.Loading->{
                        _languageHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Error->{
                        _languageHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    is NetworkResponseState.Success->{
                        _languageHomeUiState.postValue(HomeUiState.Success(it.result))
                    }
                }
            }
        }
    }

    fun pushTranslate(post:List<PostTranslateItem>){
        viewModelScope.launch {
            pushTranslateUseCase.invoke(post,fromLanguage, toLanguage).collectLatest {
                when(it){
                    is NetworkResponseState.Error->{
                        _translateHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    is NetworkResponseState.Loading->{
                        _translateHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Success->{
                        _translateHomeUiState.postValue(HomeUiState.Success(it.result))
                    }
                }
            }
        }
    }

    fun detectLanguage(post:List<PostDetectItem>){
        viewModelScope.launch {
            detectLanguageUseCase.invoke(post).collectLatest {
                when(it){
                    is NetworkResponseState.Loading->{
                        _detectLanguageHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Error->{
                        _detectLanguageHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    is NetworkResponseState.Success->{
                        _detectLanguageHomeUiState.postValue(HomeUiState.Success(it.result))
                    }
                }
            }
        }
    }







}