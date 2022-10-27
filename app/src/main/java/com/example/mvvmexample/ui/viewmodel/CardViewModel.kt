package com.example.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.data.model.CardModel
import com.example.mvvmexample.data.model.CardProvider
import com.example.mvvmexample.domain.GetCardsUseCase
import com.example.mvvmexample.domain.GetRandomCardUseCase
import kotlinx.coroutines.launch

class CardViewModel : ViewModel() {

    val cardModel = MutableLiveData<CardModel>()

    val isLoading = MutableLiveData<Boolean>()

    var getCardsUseCase = GetCardsUseCase()

    var getRandomCardUseCase = GetRandomCardUseCase()

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
        isLoading.postValue(true)

        val card = getRandomCardUseCase()

        if (card!=null){
            cardModel.postValue(card)
        }

        isLoading.postValue(false)
    }


}