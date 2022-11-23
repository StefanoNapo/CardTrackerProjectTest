package com.example.cardTrackerProject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardTrackerProject.domain.*
import com.example.cardTrackerProject.domain.model.Card
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase,
    private val getCardSearchUseCase: GetCardSearchUseCase,
    private val getCardSearchTypeUseCase: GetCardSearchTypeUseCase,
    private val getCardSearchTypeAttrMonTypeUseCase: GetCardSearchTypeAttrMonTypeUseCase,
    private val getCardSearchTypeMonTypeUseCase: GetCardSearchTypeMonTypeUseCase
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


    fun cardSearch(searchQuery : String) {

        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchUseCase.invoke(searchQuery)

            if (cardSearched.isNotEmpty()){
                cardSearch.postValue(cardSearched)
            }


            isLoading.postValue(false)
        }

    }

    fun cardSearchWithType(searchQuery: String, searchType: String){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeUseCase.invoke(searchQuery, searchType)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonType(searchQuery: String, searchType: String, monsType: String){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeUseCase.invoke(searchQuery, searchType, monsType)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

   fun cardSearchWithTypeAttrMonType(searchQuery: String, searchType: String, searchAttr: String, monsType: String){
       viewModelScope.launch {
           isLoading.postValue(true)

           val cardSearched = getCardSearchTypeAttrMonTypeUseCase.invoke(searchQuery, searchType, searchAttr, monsType)

           cardSearch.postValue(cardSearched)


           isLoading.postValue(false)
       }
   }

}