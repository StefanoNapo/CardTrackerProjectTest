package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchMonTypeLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, monsType: String, searchLvl: Int): List<Card> {


        return repository.searchCardsNameWithMonTypeLvl(searchQuery, monsType, searchLvl)


    }
}