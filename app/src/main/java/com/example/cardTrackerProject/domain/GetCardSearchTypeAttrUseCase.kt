package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeAttrUseCase @Inject constructor(private val repository: CardRepository){

    suspend operator fun invoke(searchQuery: String, searchType: String, searchAttr: String): List<Card> {

        val cardsSearched = repository.getAllCardsFromDatabase()

        val response = repository.searchCardsNameWithTypeAttr(searchQuery, searchType, searchAttr)

        return if (cardsSearched.isNotEmpty()) {
            response
        } else {
            return emptyList()
        }

    }
}