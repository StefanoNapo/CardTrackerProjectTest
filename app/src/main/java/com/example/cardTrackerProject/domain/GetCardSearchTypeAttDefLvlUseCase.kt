package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeAttDefLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchDef: Int,
        searchLvl: Int
    ): List<Card> {


        return repository.searchCardsWithTypeAttrDefLvl(
            searchQuery,
            searchType,
            searchAttr,
            searchDef,
            searchLvl
        )


    }
}