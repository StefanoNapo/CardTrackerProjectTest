package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchDefLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, searchDef: Int, searchLvl: Int): List<Card> {


        return repository.searchCardsNameWithDefLvl(searchQuery, searchDef, searchLvl)

    }
}