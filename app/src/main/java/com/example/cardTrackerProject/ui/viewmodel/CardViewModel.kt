package com.example.cardTrackerProject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardTrackerProject.domain.GetCardSearchUseCase
import com.example.cardTrackerProject.domain.GetCardsUseCase
import com.example.cardTrackerProject.domain.model.Card
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase,
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


    fun cardSearch(query : String) {

        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchUseCase.invoke(query)

            if (cardSearched.isNotEmpty()){
                cardSearch.postValue(cardSearched)
            }


            isLoading.postValue(false)
        }

    }


}