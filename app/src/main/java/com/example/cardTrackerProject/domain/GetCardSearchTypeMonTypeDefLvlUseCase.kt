package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeMonTypeDefLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchDef: Int,
        searchLvl: Int
    ): List<Card> {


        return repository.searchCardsWithTypeMonTypeDefLvl(
            searchQuery,
            searchType,
            monsType,
            searchDef,
            searchLvl
        )


    }
}