package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchMonTypeAttrLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchLvl: Int
    ): List<Card> {


        return repository.searchCardsWithMonTypeAttrLvl(
            searchQuery,
            monsType,
            searchAttr,
            searchLvl
        )


    }
}