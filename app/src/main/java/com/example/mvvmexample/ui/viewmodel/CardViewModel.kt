package com.example.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.domain.GetCardsUseCase
import com.example.mvvmexample.domain.GetRandomCardUseCase
import com.example.mvvmexample.domain.model.Card
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase,
    private val getRandomCardUseCase: GetRandomCardUseCase
): ViewModel() {

    val cardModel = MutableLiveData<Card>()

    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCardsUseCase()

            if (!result.isNullOrEmpty()){
                cardModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomCard(){
        viewModelScope.launch {
            isLoading.postValue(true)

            val card = getRandomCardUseCase()

            if (card != null) {
                cardModel.postValue(card)
            }

            isLoading.postValue(false)
        }
    }


}