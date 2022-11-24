package com.example.cardTrackerProject.ui.viewmodel

import android.widget.Toast
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
    private val getCardSearchMonTypeUseCase: GetCardSearchMonTypeUseCase,
    private val getCardSearchAttrUseCase: GetCardSearchAttrUseCase,
    private val getCardSearchTypeMonTypeUseCase: GetCardSearchTypeMonTypeUseCase,
    private val getCardSearchTypeAttrUseCase: GetCardSearchTypeAttrUseCase,
    private val getCardSearchMonTypeAttrUseCase: GetCardSearchMonTypeAttrUseCase,
    private val getCardSearchTypeAttrMonTypeUseCase: GetCardSearchTypeAttrMonTypeUseCase

) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    val cardSearch = MutableLiveData<List<Card>>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            getCardsUseCase()

            isLoading.postValue(false)

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

    fun cardSearchWithMonType(searchQuery : String, monsType: String){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeUseCase.invoke(searchQuery, monsType)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttr(searchQuery: String, searchAttr: String){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAttrUseCase.invoke(searchQuery, searchAttr)

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

    fun cardSearchWithTypeAttr(searchQuery: String, searchType: String, searchAttr: String){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrUseCase.invoke(searchQuery, searchType, searchAttr)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAttr(searchQuery: String, monsType: String, searchAttr: String){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAttrUseCase.invoke(searchQuery, monsType, searchAttr)

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