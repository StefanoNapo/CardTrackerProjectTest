package com.example.cardTrackerProject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardTrackerProject.domain.*
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.domain.GetCardSearchAtkUseCase
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
    private val getCardSearchAtkUseCase: GetCardSearchAtkUseCase,
    private val getCardSearchDefUseCase: GetCardSearchDefUseCase,
    private val getCardSearchLvlUseCase: GetCardSearchLvlUseCase,
    private val getCardSearchTypeMonTypeUseCase: GetCardSearchTypeMonTypeUseCase,
    private val getCardSearchTypeAttrUseCase: GetCardSearchTypeAttrUseCase,
    private val getCardSearchMonTypeAttrUseCase: GetCardSearchMonTypeAttrUseCase,
    private val getCardSearchTypeAtkUseCase: GetCardSearchTypeAtkUseCase,
    private val getCardSearchTypeDefUseCase: GetCardSearchTypeDefUseCase,
    private val getCardSearchTypeLvlUseCase: GetCardSearchTypeLvlUseCase,
    private val getCardSearchMonTypeAtkUseCase: GetCardSearchMonTypeAtkUseCase,
    private val getCardSearchMonTypeDefUseCase: GetCardSearchMonTypeDefUseCase,
    private val getCardSearchMonTypeLvlUseCase: GetCardSearchMonTypeLvlUseCase,
    private val getCardSearchAttrAtkUseCase: GetCardSearchAttrAtkUseCase,
    private val getCardSearchAttrDefUseCase: GetCardSearchAttrDefUseCase,
    private val getCardSearchAttrLvlUseCase: GetCardSearchAttrLvlUseCase,
    private val getCardSearchAtkDefUseCase: GetCardSearchAtkDefUseCase,
    private val getCardSearchAtkLvlUseCase: GetCardSearchAtkLvlUseCase,
    private val getCardSearchDefLvlUseCase: GetCardSearchDefLvlUseCase,
    private val getCardSearchTypeAttrMonTypeUseCase: GetCardSearchTypeAttrMonTypeUseCase,
    private val getCardSearchTypeMonTypeAtkUseCase: GetCardSearchTypeMonTypeAtkUseCase,
    private val getCardSearchTypeMonTypeDefUseCase: GetCardSearchTypeMonTypeDefUseCase,
    private val getCardSearchTypeMonTypeLvlUseCase: GetCardSearchTypeMonTypeLvlUseCase,
    private val getCardSearchTypeAttrAtkUseCase: GetCardSearchTypeAttrAtkUseCase,
    private val getCardSearchTypeAttrDefUseCase: GetCardSearchTypeAttrDefUseCase,
    private val getCardSearchTypeAttrLvlUseCase: GetCardSearchTypeAttrLvlUseCase,
    private val getCardSearchTypeAtkDefUseCase: GetCardSearchTypeAtkDefUseCase,
    private val getCardSearchTypeAtkLvlUseCase: GetCardSearchTypeAtkLvlUseCase,
    private val getCardSearchTypeDefLvlUseCase: GetCardSearchTypeDefLvlUseCase,
    private val getCardSearchTAMTAtkDUseCase: GetCardSearchTAMTAtkDUseCase,
    private val getCardSearchTAMTAtkDLUseCase: GetCardSearchTAMTAtkDLUseCase

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

    fun cardSearchWithAtk(searchQuery: String, searchAtk: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAtkUseCase.invoke(searchQuery, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithDef(searchQuery: String, searchDef: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchDefUseCase.invoke(searchQuery, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithLvl(searchQuery: String, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchLvlUseCase.invoke(searchQuery, searchLvl)

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

    fun cardSearchWithTypeAtk(searchQuery: String, searchType: String, searchAtk: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAtkUseCase.invoke(searchQuery, searchType, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeDef(searchQuery: String, searchType: String, searchDef: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeDefUseCase.invoke(searchQuery, searchType, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeLvl(searchQuery: String, searchType: String, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeLvlUseCase.invoke(searchQuery, searchType, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAtk(searchQuery: String, monsType: String, searchAtk: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAtkUseCase.invoke(searchQuery, monsType, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeDef(searchQuery: String, monsType: String, searchDef: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeDefUseCase.invoke(searchQuery, monsType, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeLvl(searchQuery: String, monsType: String, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeLvlUseCase.invoke(searchQuery, monsType, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrAtk(searchQuery: String, searchAttr: String, searchAtk: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAttrAtkUseCase.invoke(searchQuery, searchAttr, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrDef(searchQuery: String, searchAttr: String, searchDef: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAttrDefUseCase.invoke(searchQuery, searchAttr, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrLvl(searchQuery: String, searchAttr: String, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAttrLvlUseCase.invoke(searchQuery, searchAttr, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAtkDef(searchQuery: String, searchDef: Int, searchAtk: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAtkDefUseCase.invoke(searchQuery, searchDef, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAtkLvl(searchQuery: String, searchLvl: Int, searchAtk: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAtkLvlUseCase.invoke(searchQuery, searchLvl, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithDefLvl(searchQuery: String, searchDef: Int, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchDefLvlUseCase.invoke(searchQuery, searchDef, searchLvl)

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

    fun cardSearchWithTypeMonTypeAtk(searchQuery: String, searchType: String, monsType: String, searchAtk: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeAtkUseCase.invoke(searchQuery, searchType, monsType, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeDef(searchQuery: String, searchType: String, monsType: String, searchDef: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeDefUseCase.invoke(searchQuery, searchType, monsType, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeLvl(searchQuery: String, searchType: String, monsType: String, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeLvlUseCase.invoke(searchQuery, searchType, monsType, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrAtk(searchQuery: String, searchType: String, searchAttr: String, searchAtk: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrAtkUseCase.invoke(searchQuery, searchType, searchAttr, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrDef(searchQuery: String, searchType: String, searchAttr: String, searchDef: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrDefUseCase.invoke(searchQuery, searchType, searchAttr, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrLvl(searchQuery: String, searchType: String, searchAttr: String, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrLvlUseCase.invoke(searchQuery, searchType, searchAttr, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAtkDef(searchQuery: String, searchType: String, searchAtk: Int, searchDef: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAtkDefUseCase.invoke(searchQuery, searchType, searchAtk, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAtkLvl(searchQuery: String, searchType: String, searchAtk: Int, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAtkLvlUseCase.invoke(searchQuery, searchType, searchAtk, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeDefLvl(searchQuery: String, searchType: String, searchDef: Int, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeDefLvlUseCase.invoke(searchQuery, searchType, searchDef, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTAMTAtkD(searchQuery: String, searchType: String, searchAttr: String, monsType: String, searchAtk: Int, searchDef: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTAMTAtkDUseCase.invoke(searchQuery, searchType, searchAttr, monsType, searchAtk, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTAMTAtkDL(searchQuery: String, searchType: String, searchAttr: String, monsType: String, searchAtk: Int, searchDef: Int, searchLvl: Int){
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTAMTAtkDLUseCase.invoke(searchQuery, searchType, searchAttr, monsType, searchAtk, searchDef, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

}