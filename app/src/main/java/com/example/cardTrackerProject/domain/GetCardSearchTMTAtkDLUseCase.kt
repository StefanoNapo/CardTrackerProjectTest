package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTMTAtkDLUseCase @Inject constructor(private val repository: CardRepository){

    suspend operator fun invoke(searchQuery: String, searchType: String, monsType: String, searchAtk: Int, searchDef: Int, searchLvl: Int): List<Card> {


        return repository.searchCardsWithTMTAtkDL(searchQuery, searchType, monsType, searchAtk, searchDef, searchLvl)


    }
}