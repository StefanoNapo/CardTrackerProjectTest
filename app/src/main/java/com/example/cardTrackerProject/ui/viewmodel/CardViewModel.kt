package com.example.cardTrackerProject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardTrackerProject.data.database.entities.CompetitiveCollectionEntity
import com.example.cardTrackerProject.data.database.entities.ForSaleCollectionEntity
import com.example.cardTrackerProject.data.database.entities.MyCollectionEntity
import com.example.cardTrackerProject.data.model.CardChecked
import com.example.cardTrackerProject.domain.*
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.domain.GetCardSearchAtkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
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
    private val getCardSearchMonTypeAttrAtkUseCase: GetCardSearchMonTypeAttrAtkUseCase,
    private val getCardSearchMonTypeAttrDefUseCase: GetCardSearchMonTypeAttrDefUseCase,
    private val getCardSearchMonTypeAttrLvlUseCase: GetCardSearchMonTypeAttrLvlUseCase,
    private val getCardSearchMonTypeAtkDefUseCase: GetCardSearchMonTypeAtkDefUseCase,
    private val getCardSearchMonTypeAtkLvlUseCase: GetCardSearchMonTypeAtkLvlUseCase,
    private val getCardSearchMonTypeDefLvlUseCase: GetCardSearchMonTypeDefLvlUseCase,
    private val getCardSearchAttrAtkDefUseCase: GetCardSearchAttrAtkDefUseCase,
    private val getCardSearchAttrAtkLvlUseCase: GetCardSearchAttrAtkLvlUseCase,
    private val getCardSearchAttrDefLvlUseCase: GetCardSearchAttrDefLvlUseCase,
    private val getCardSearchAtkDefLvlUseCase: GetCardSearchAtkDefLvlUseCase,
    private val getCardSearchTypeMTypeAttrAtkUseCase: GetCardSearchTypeMTypeAttrAtkUseCase,
    private val getCardSearchTypeMTypeAttrDefUseCase: GetCardSearchTypeMTypeAttrDefUseCase,
    private val getCardSearchTypeMTypeAttrLvlUseCase: GetCardSearchTypeMTypeAttrLvlUseCase,
    private val getCardSearchTypeMonTypeAtkDefUseCase: GetCardSearchTypeMonTypeAtkDefUseCase,
    private val getCardSearchTypeMonTypeAtkLvlUseCase: GetCardSearchTypeMonTypeAtkLvlUseCase,
    private val getCardSearchTypeMonTypeDefLvlUseCase: GetCardSearchTypeMonTypeDefLvlUseCase,
    private val getCardSearchTypeAttrAtkDefUseCase: GetCardSearchTypeAttrAtkDefUseCase,
    private val getCardSearchTypeAttrAtkLvlUseCase: GetCardSearchTypeAttrAtkLvlUseCase,
    private val getCardSearchTypeAttDefLvlUseCase: GetCardSearchTypeAttDefLvlUseCase,
    private val getCardSearchTypeAtkDefLvlUseCase: GetCardSearchTypeAtkDefLvlUseCase,
    private val getCardSearchMonTypeAttrAtkDefUseCase: GetCardSearchMonTypeAttrAtkDefUseCase,
    private val getCardSearchMonTypeAttrAtkLvlUseCase: GetCardSearchMonTypeAttrAtkLvlUseCase,
    private val getCardSearchMonTypeAttrDefLvlUseCase: GetCardSearchMonTypeAttrDefLvlUseCase,
    private val getCardSearchMonTypeAtkDefLvlUseCase: GetCardSearchMonTypeAtkDefLvlUseCase,
    private val getCardSearchAttrAtkDefLvlUseCase: GetCardSearchAttrAtkDefLvlUseCase,
    private val getCardSearchTAMTAtkDUseCase: GetCardSearchTAMTAtkDUseCase,
    private val getCardSearchTAMTAtkLUseCase: GetCardSearchTAMTAtkLUseCase,
    private val getCardSearchTAMTDLUseCase: GetCardSearchTAMTDLUseCase,
    private val getCardSearchTAAtkDLUseCase: GetCardSearchTAAtkDLUseCase,
    private val getCardSearchTMTAtkDLUseCase: GetCardSearchTMTAtkDLUseCase,
    private val getCardSearchMTAAtkDLUseCase: GetCardSearchMTAAtkDLUseCase,
    private val getCardSearchTAMTAtkDLUseCase: GetCardSearchTAMTAtkDLUseCase,
    private val getCardSearchOnlyNameUseCase: GetCardSearchOnlyNameUseCase,
    private val getCardsCompUseCase: GetCardsCompUseCase,
    private val getCardsForSaleUseCase: GetCardsForSaleUseCase,
    private val getCardsMyCollUseCase: GetCardsMyCollUseCase,
    private val getCardSearchMyCollUseCase: GetCardSearchMyCollUseCase,
    private val getCardSearchForSaleCollUseCase: GetCardSearchForSaleCollUseCase,
    private val getCardSearchCompCollUseCase: GetCardSearchCompCollUseCase,
    private val getAllCardsMyCollUseCase: GetAllCardsMyCollUseCase,
    private val getAllCardsForSaleCollUseCase: GetAllCardsForSaleCollUseCase,
    private val getAllCardsCompCollUseCase: GetAllCardsCompCollUseCase,
    private val setCardQuantityMyCollUseCase: SetCardQuantityMyCollUseCase,
    private val setCardQuantityForSaleCollUseCase: SetCardQuantityForSaleCollUseCase,
    private val setCardQuantityCompCollUseCase: SetCardQuantityCompCollUseCase,
    private val deleteCardMyCollUseCase: DeleteCardMyCollUseCase,
    private val deleteCardForSaleCollUseCase: DeleteCardForSaleCollUseCase,
    private val deleteCardCompCollUseCase: DeleteCardCompCollUseCase

) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    var cardSearch = MutableLiveData<List<Card>>()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            getCardsUseCase()

            isLoading.postValue(false)

        }

    }

    fun getAllCardMyColl() {

        viewModelScope.launch {
            isLoading.postValue(true)
            getAllCardsMyCollUseCase.invoke()
            isLoading.postValue(false)
        }

    }

    fun getAllCardForSaleColl() {

        viewModelScope.launch {
            isLoading.postValue(true)
            getAllCardsForSaleCollUseCase.invoke()
            isLoading.postValue(false)
        }

    }

    fun getAllCardCompColl() {

        viewModelScope.launch {
            isLoading.postValue(true)
            getAllCardsCompCollUseCase.invoke()
            isLoading.postValue(false)
        }

    }

    fun setCardQuantityMyColl(cardName: String, cardQuantity: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            setCardQuantityMyCollUseCase.invoke(cardName, cardQuantity)
            isLoading.postValue(false)
        }
    }

    fun setCardQuantityForSaleColl(cardName: String, cardQuantity: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            setCardQuantityForSaleCollUseCase.invoke(cardName, cardQuantity)
            isLoading.postValue(false)
        }
    }

    fun setCardQuantityCompColl(cardName: String, cardQuantity: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            setCardQuantityCompCollUseCase.invoke(cardName, cardQuantity)
            isLoading.postValue(false)
        }
    }

    fun deleteCardMyColl(cardName: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            deleteCardMyCollUseCase.invoke(cardName)
            isLoading.postValue(false)
        }
    }

    fun deleteCardForSaleColl(cardName: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            deleteCardForSaleCollUseCase.invoke(cardName)
            isLoading.postValue(false)
        }
    }

    fun deleteCardCompColl(cardName: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            deleteCardCompCollUseCase.invoke(cardName)
            isLoading.postValue(false)
        }
    }

    private fun getCardsMyColl(listOfCards: MutableList<MyCollectionEntity>) {
        viewModelScope.launch {
            isLoading.postValue(true)

            if (listOfCards.isNotEmpty()) {

                getCardsMyCollUseCase(listOfCards)

            }


            isLoading.postValue(false)
        }
    }

    private fun getCardsForSale(listOfCards: MutableList<ForSaleCollectionEntity>) {
        viewModelScope.launch {
            isLoading.postValue(true)

            if (listOfCards.isNotEmpty()) {

                getCardsForSaleUseCase(listOfCards)

            }


            isLoading.postValue(false)
        }
    }

    private fun getCardsComp(listOfCards: MutableList<CompetitiveCollectionEntity>) {
        viewModelScope.launch {
            isLoading.postValue(true)

            if (listOfCards.isNotEmpty()) {

                getCardsCompUseCase(listOfCards)

            }


            isLoading.postValue(false)
        }
    }

    fun setListMyColl(list: MutableList<CardChecked>) {
        viewModelScope.launch {
            val cardsToSendForSale: MutableList<MyCollectionEntity> = ArrayList()

            for ((index) in list.withIndex()) {
                val cardName = list[index].cardName

                val cardQuant = list[index].cardQuant

                val cardSearchList = getCardSearchOnlyNameUseCase.invoke(cardName)

                if (cardSearchList.isNotEmpty()) {
                    cardSearch.postValue(cardSearchList)
                }

                delay(100)
                val cardsSearchedList: List<Card>? = cardSearch.value


                val selCardId = cardsSearchedList?.get(0)?.id
                val selCardName = cardsSearchedList?.get(0)?.name
                val selCardType = cardsSearchedList?.get(0)?.type
                val selCardDesc = cardsSearchedList?.get(0)?.desc
                val selCardAtk = cardsSearchedList?.get(0)?.atk
                val selCardRace = cardsSearchedList?.get(0)?.race
                val selCardAttr = cardsSearchedList?.get(0)?.attribute
                val selCardArch = cardsSearchedList?.get(0)?.archetype
                val selCardLinkVal = cardsSearchedList?.get(0)?.linkval
                val selCardLinkMark = cardsSearchedList?.get(0)?.linkmarkers
                val selCardSets = cardsSearchedList?.get(0)?.cardSets
                val selCardImages = cardsSearchedList?.get(0)?.cardImages
                val selCardPrices = cardsSearchedList?.get(0)?.cardPrices
                val selCardDef = cardsSearchedList?.get(0)?.def
                val selCardLvl = cardsSearchedList?.get(0)?.level

                val newCard = MyCollectionEntity(
                    selCardId,
                    selCardName,
                    selCardType,
                    selCardDesc,
                    selCardAtk,
                    selCardRace,
                    selCardAttr,
                    selCardArch,
                    selCardLinkVal,
                    selCardLinkMark,
                    selCardSets,
                    selCardImages,
                    selCardPrices,
                    selCardDef,
                    selCardLvl,
                    cardQuant
                )

                cardsToSendForSale += newCard


            }

            getCardsMyColl(cardsToSendForSale)

        }
    }


    fun setListForSale(list: MutableList<CardChecked>) {
        viewModelScope.launch {
            val cardsToSendForSale: MutableList<ForSaleCollectionEntity> = ArrayList()

            for ((index) in list.withIndex()) {
                val cardName = list[index].cardName

                val cardQuant = list[index].cardQuant

                val cardSearchList = getCardSearchOnlyNameUseCase.invoke(cardName)

                if (cardSearchList.isNotEmpty()) {
                    cardSearch.postValue(cardSearchList)
                }

                delay(100)
                val cardsSearchedList: List<Card>? = cardSearch.value


                val selCardId = cardsSearchedList?.get(0)?.id
                val selCardName = cardsSearchedList?.get(0)?.name
                val selCardType = cardsSearchedList?.get(0)?.type
                val selCardDesc = cardsSearchedList?.get(0)?.desc
                val selCardAtk = cardsSearchedList?.get(0)?.atk
                val selCardRace = cardsSearchedList?.get(0)?.race
                val selCardAttr = cardsSearchedList?.get(0)?.attribute
                val selCardArch = cardsSearchedList?.get(0)?.archetype
                val selCardLinkVal = cardsSearchedList?.get(0)?.linkval
                val selCardLinkMark = cardsSearchedList?.get(0)?.linkmarkers
                val selCardSets = cardsSearchedList?.get(0)?.cardSets
                val selCardImages = cardsSearchedList?.get(0)?.cardImages
                val selCardPrices = cardsSearchedList?.get(0)?.cardPrices
                val selCardDef = cardsSearchedList?.get(0)?.def
                val selCardLvl = cardsSearchedList?.get(0)?.level

                val newCard = ForSaleCollectionEntity(
                    selCardId,
                    selCardName,
                    selCardType,
                    selCardDesc,
                    selCardAtk,
                    selCardRace,
                    selCardAttr,
                    selCardArch,
                    selCardLinkVal,
                    selCardLinkMark,
                    selCardSets,
                    selCardImages,
                    selCardPrices,
                    selCardDef,
                    selCardLvl,
                    cardQuant
                )

                cardsToSendForSale += newCard


            }

            getCardsForSale(cardsToSendForSale)

        }
    }

    fun setListComp(list: MutableList<CardChecked>) {
        viewModelScope.launch {
            val cardsToSendComp: MutableList<CompetitiveCollectionEntity> = ArrayList()

            for ((index) in list.withIndex()) {
                val cardName = list[index].cardName

                val cardQuant = list[index].cardQuant

                val cardSearchList = getCardSearchOnlyNameUseCase.invoke(cardName)

                if (cardSearchList.isNotEmpty()) {
                    cardSearch.postValue(cardSearchList)
                }

                delay(100)
                val cardsSearchedList: List<Card>? = cardSearch.value


                val selCardId = cardsSearchedList?.get(0)?.id
                val selCardName = cardsSearchedList?.get(0)?.name
                val selCardType = cardsSearchedList?.get(0)?.type
                val selCardDesc = cardsSearchedList?.get(0)?.desc
                val selCardAtk = cardsSearchedList?.get(0)?.atk
                val selCardRace = cardsSearchedList?.get(0)?.race
                val selCardAttr = cardsSearchedList?.get(0)?.attribute
                val selCardArch = cardsSearchedList?.get(0)?.archetype
                val selCardLinkVal = cardsSearchedList?.get(0)?.linkval
                val selCardLinkMark = cardsSearchedList?.get(0)?.linkmarkers
                val selCardSets = cardsSearchedList?.get(0)?.cardSets
                val selCardImages = cardsSearchedList?.get(0)?.cardImages
                val selCardPrices = cardsSearchedList?.get(0)?.cardPrices
                val selCardDef = cardsSearchedList?.get(0)?.def
                val selCardLvl = cardsSearchedList?.get(0)?.level

                val newCard = CompetitiveCollectionEntity(
                    selCardId,
                    selCardName,
                    selCardType,
                    selCardDesc,
                    selCardAtk,
                    selCardRace,
                    selCardAttr,
                    selCardArch,
                    selCardLinkVal,
                    selCardLinkMark,
                    selCardSets,
                    selCardImages,
                    selCardPrices,
                    selCardDef,
                    selCardLvl,
                    cardQuant
                )

                cardsToSendComp += newCard


            }

            getCardsComp(cardsToSendComp)

        }
    }


    fun cardSearch(searchQuery: String) {

        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchUseCase.invoke(searchQuery)

            if (cardSearched.isNotEmpty()) {
                cardSearch.postValue(cardSearched)
            }


            isLoading.postValue(false)
        }

    }

    fun cardSearchForClearList() {

        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchUseCase.invoke("")


            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }

    }

    fun cardSearchMyColl(searchQuery: String) {

        //Ver como hacer la busqueda para que consulte todos los valores de la tabla con los del total de cartas

        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchUseCase.invoke(searchQuery)
            val cardSearchedMyColl = getCardSearchMyCollUseCase.invoke(searchQuery)
            val cardListSend: MutableList<Card> = mutableListOf()
            var cardSearchId: Int?
            var cardSearchCollId: Int?

            if (cardSearched.isNotEmpty()) {
                for ((index) in cardSearchedMyColl.withIndex()) {
                    for ((index2) in cardSearched.withIndex()) {
                        cardSearchId = cardSearched[index2].id
                        cardSearchCollId = cardSearchedMyColl[index].id

                        if (cardSearchId == cardSearchCollId) {
                            cardListSend.add(cardSearched[index2])
                            break
                        }

                    }

                }

                cardSearch.postValue(cardListSend)

            }


            isLoading.postValue(false)
        }

    }

    fun cardSearchForSale(searchQuery: String) {

        //Ver como hacer la busqueda para que consulte todos los valores de la tabla con los del total de cartas

        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchUseCase.invoke(searchQuery)
            val cardSearchedForSale = getCardSearchForSaleCollUseCase.invoke(searchQuery)
            val cardListSend: MutableList<Card> = mutableListOf()
            var cardSearchId: Int?
            var cardSearchForSaleId: Int?

            if (cardSearched.isNotEmpty()) {
                for ((index) in cardSearchedForSale.withIndex()) {
                    for ((index2) in cardSearched.withIndex()) {
                        cardSearchId = cardSearched[index2].id
                        cardSearchForSaleId = cardSearchedForSale[index].id

                        if (cardSearchId == cardSearchForSaleId) {
                            cardListSend.add(cardSearched[index2])
                            break
                        }

                    }

                }

                cardSearch.postValue(cardListSend)

            }


            isLoading.postValue(false)
        }

    }

    fun cardSearchCompColl(searchQuery: String) {

        //Ver como hacer la busqueda para que consulte todos los valores de la tabla con los del total de cartas

        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchUseCase.invoke(searchQuery)
            val cardSearchedCompColl = getCardSearchCompCollUseCase.invoke(searchQuery)
            val cardListSend: MutableList<Card> = mutableListOf()
            var cardSearchId: Int?
            var cardSearchCompCollId: Int?

            if (cardSearched.isNotEmpty()) {
                for ((index) in cardSearchedCompColl.withIndex()) {
                    for ((index2) in cardSearched.withIndex()) {
                        cardSearchId = cardSearched[index2].id
                        cardSearchCompCollId = cardSearchedCompColl[index].id

                        if (cardSearchId == cardSearchCompCollId) {
                            cardListSend.add(cardSearched[index2])
                            break
                        }

                    }

                }

                cardSearch.postValue(cardListSend)

            }


            isLoading.postValue(false)
        }

    }

    fun cardSearchWithType(searchQuery: String, searchType: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeUseCase.invoke(searchQuery, searchType)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonType(searchQuery: String, monsType: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeUseCase.invoke(searchQuery, monsType)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttr(searchQuery: String, searchAttr: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAttrUseCase.invoke(searchQuery, searchAttr)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAtk(searchQuery: String, searchAtk: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAtkUseCase.invoke(searchQuery, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithDef(searchQuery: String, searchDef: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchDefUseCase.invoke(searchQuery, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithLvl(searchQuery: String, searchLvl: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchLvlUseCase.invoke(searchQuery, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonType(searchQuery: String, searchType: String, monsType: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchTypeMonTypeUseCase.invoke(searchQuery, searchType, monsType)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttr(searchQuery: String, searchType: String, searchAttr: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchTypeAttrUseCase.invoke(searchQuery, searchType, searchAttr)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAttr(searchQuery: String, monsType: String, searchAttr: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchMonTypeAttrUseCase.invoke(searchQuery, monsType, searchAttr)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAtk(searchQuery: String, searchType: String, searchAtk: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchTypeAtkUseCase.invoke(searchQuery, searchType, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeDef(searchQuery: String, searchType: String, searchDef: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchTypeDefUseCase.invoke(searchQuery, searchType, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeLvl(searchQuery: String, searchType: String, searchLvl: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchTypeLvlUseCase.invoke(searchQuery, searchType, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAtk(searchQuery: String, monsType: String, searchAtk: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchMonTypeAtkUseCase.invoke(searchQuery, monsType, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeDef(searchQuery: String, monsType: String, searchDef: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchMonTypeDefUseCase.invoke(searchQuery, monsType, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeLvl(searchQuery: String, monsType: String, searchLvl: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchMonTypeLvlUseCase.invoke(searchQuery, monsType, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrAtk(searchQuery: String, searchAttr: String, searchAtk: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchAttrAtkUseCase.invoke(searchQuery, searchAttr, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrDef(searchQuery: String, searchAttr: String, searchDef: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchAttrDefUseCase.invoke(searchQuery, searchAttr, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrLvl(searchQuery: String, searchAttr: String, searchLvl: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchAttrLvlUseCase.invoke(searchQuery, searchAttr, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAtkDef(searchQuery: String, searchDef: Int, searchAtk: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAtkDefUseCase.invoke(searchQuery, searchDef, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAtkLvl(searchQuery: String, searchLvl: Int, searchAtk: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAtkLvlUseCase.invoke(searchQuery, searchLvl, searchAtk)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithDefLvl(searchQuery: String, searchDef: Int, searchLvl: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchDefLvlUseCase.invoke(searchQuery, searchDef, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrMonType(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrMonTypeUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                monsType
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeAtk(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAtk: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeAtkUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchAtk
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeDef(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeDefUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeLvl(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeLvlUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrAtk(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchAtk: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrAtkUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                searchAtk
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrDef(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrDefUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrLvl(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrLvlUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAtkDef(
        searchQuery: String,
        searchType: String,
        searchAtk: Int,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchTypeAtkDefUseCase.invoke(searchQuery, searchType, searchAtk, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAtkLvl(
        searchQuery: String,
        searchType: String,
        searchAtk: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchTypeAtkLvlUseCase.invoke(searchQuery, searchType, searchAtk, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeDefLvl(
        searchQuery: String,
        searchType: String,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchTypeDefLvlUseCase.invoke(searchQuery, searchType, searchDef, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAttrAtk(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAttrAtkUseCase.invoke(
                searchQuery,
                monsType,
                searchAttr,
                searchAtk
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAttrDef(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAttrDefUseCase.invoke(
                searchQuery,
                monsType,
                searchAttr,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAttrLvl(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAttrLvlUseCase.invoke(
                searchQuery,
                monsType,
                searchAttr,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAtkDef(
        searchQuery: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAtkDefUseCase.invoke(
                searchQuery,
                monsType,
                searchAtk,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAtkLvl(
        searchQuery: String,
        monsType: String,
        searchAtk: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAtkLvlUseCase.invoke(
                searchQuery,
                monsType,
                searchAtk,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeDefLvl(
        searchQuery: String,
        monsType: String,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeDefLvlUseCase.invoke(
                searchQuery,
                monsType,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrAtkDef(
        searchQuery: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchAttrAtkDefUseCase.invoke(searchQuery, searchAttr, searchAtk, searchDef)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrAtkLvl(
        searchQuery: String,
        searchAttr: String,
        searchAtk: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchAttrAtkLvlUseCase.invoke(searchQuery, searchAttr, searchAtk, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrDefLvl(
        searchQuery: String,
        searchAttr: String,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchAttrDefLvlUseCase.invoke(searchQuery, searchAttr, searchDef, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAtkDefLvl(
        searchQuery: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched =
                getCardSearchAtkDefLvlUseCase.invoke(searchQuery, searchAtk, searchDef, searchLvl)

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeAttrAtk(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMTypeAttrAtkUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchAttr,
                searchAtk
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeAttrDef(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAttr: String,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMTypeAttrDefUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchAttr,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeAttrLvl(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAttr: String,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMTypeAttrLvlUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchAttr,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeAtkDef(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeAtkDefUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchAtk,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeAtkLvl(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAtk: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeAtkLvlUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchAtk,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeMonTypeDefLvl(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeMonTypeDefLvlUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrAtkDef(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrAtkDefUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                searchAtk,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrAtkLvl(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchAtk: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttrAtkLvlUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                searchAtk,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAttrDefLvl(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAttDefLvlUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTypeAtkDefLvl(
        searchQuery: String,
        searchType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTypeAtkDefLvlUseCase.invoke(
                searchQuery,
                searchType,
                searchAtk,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAttrAtkDef(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAttrAtkDefUseCase.invoke(
                searchQuery,
                monsType,
                searchAttr,
                searchAtk,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAttrAtkLvl(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAttrAtkLvlUseCase.invoke(
                searchQuery,
                monsType,
                searchAttr,
                searchAtk,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAttrDefLvl(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAttrDefLvlUseCase.invoke(
                searchQuery,
                monsType,
                searchAttr,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMonTypeAtkDefLvl(
        searchQuery: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMonTypeAtkDefLvlUseCase.invoke(
                searchQuery,
                monsType,
                searchAtk,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithAttrAtkDefLvl(
        searchQuery: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchAttrAtkDefLvlUseCase.invoke(
                searchQuery,
                searchAttr,
                searchAtk,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTAMTAtkD(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTAMTAtkDUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                monsType,
                searchAtk,
                searchDef
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTAMTAtkL(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String,
        searchAtk: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTAMTAtkLUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                monsType,
                searchAtk,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTAMTDL(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTAMTDLUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                monsType,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTAAtkDL(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTAAtkDLUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                searchAtk,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTMTAtkDL(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTMTAtkDLUseCase.invoke(
                searchQuery,
                searchType,
                monsType,
                searchAtk,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithMTAAtkDL(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchMTAAtkDLUseCase.invoke(
                searchQuery,
                monsType,
                searchAttr,
                searchAtk,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

    fun cardSearchWithTAMTAtkDL(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cardSearched = getCardSearchTAMTAtkDLUseCase.invoke(
                searchQuery,
                searchType,
                searchAttr,
                monsType,
                searchAtk,
                searchDef,
                searchLvl
            )

            cardSearch.postValue(cardSearched)


            isLoading.postValue(false)
        }
    }

}