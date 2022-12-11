package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeMonTypeUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(
        searchQuery: String,
        searchType: String,
        monsType: String
    ): List<Card> {


        return repository.searchCardsNameWithTypeMonType(searchQuery, searchType, monsType)


    }
}