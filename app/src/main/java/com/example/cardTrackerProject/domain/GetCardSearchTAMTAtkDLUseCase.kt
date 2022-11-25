package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTAMTAtkDLUseCase @Inject constructor(private val repository: CardRepository){

    suspend operator fun invoke(searchQuery: String, searchType: String, searchAttr: String, monsType: String, searchAtk: Int, searchDef: Int, searchLvl: Int): List<Card> {


        return repository.searchCardsWithTAMTAtkDL(searchQuery, searchType, searchAttr, monsType, searchAtk, searchDef, searchLvl)

    }
}