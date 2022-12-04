package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeDefLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, searchType: String, searchDef: Int, searchLvl: Int): List<Card> {


        return repository.searchCardsWithTypeDefLvl(searchQuery, searchType, searchDef, searchLvl)


    }
}