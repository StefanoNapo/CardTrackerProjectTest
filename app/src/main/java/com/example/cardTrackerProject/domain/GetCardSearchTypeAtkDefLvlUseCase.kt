package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeAtkDefLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(
        searchQuery: String,
        searchType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<Card> {


        return repository.searchCardsWithTypeAtkDefLvl(
            searchQuery,
            searchType,
            searchAtk,
            searchDef,
            searchLvl
        )


    }
}