package com.example.cardTrackerProject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardTrackerProject.data.database.dao.CardDao
import com.example.cardTrackerProject.domain.GetCardSearchUseCase
import com.example.cardTrackerProject.domain.GetCardsUseCase
import com.example.cardTrackerProject.domain.GetRandomCardUseCase
import com.example.cardTrackerProject.domain.model.Card
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase,
    private val getRandomCardUseCase: GetRandomCardUseCase,
    private val getCardSearchUseCase: GetCardSearchUseCase
) : ViewModel() {

    val cardModel = MutableLiveData<Card>()

    val isLoading = MutableLiveData<Boolean>()

    val cardSearch = MutableLiveData<List<Card>>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCardsUseCase()

            if (!result.isNullOrEmpty()) {
                cardModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }

    }

    fun randomCard() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val card = getRandomCardUseCase()

            if (card != null) {
                cardModel.postValue(card)
            }

            isLoading.postValue(false)
        }
    }

    fun cardSearch() {

        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchUseCase()

            if (cardSearched.isNotEmpty()){
                cardSearch.postValue(cardSearched)
            }


            isLoading.postValue(false)
        }

    }


}