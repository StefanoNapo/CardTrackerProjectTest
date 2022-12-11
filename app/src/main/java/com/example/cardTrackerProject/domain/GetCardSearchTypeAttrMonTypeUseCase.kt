package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeAttrMonTypeUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String
    ): List<Card> {


        return repository.searchCardsWithTypeAttrMonType(
            searchQuery,
            searchType,
            searchAttr,
            monsType
        )


    }
}