package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchAttrDefLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, searchAttr: String, searchDef: Int, searchLvl: Int): List<Card> {


        return repository.searchCardsWithAttrDefLvl(searchQuery, searchAttr, searchDef, searchLvl)


    }
}