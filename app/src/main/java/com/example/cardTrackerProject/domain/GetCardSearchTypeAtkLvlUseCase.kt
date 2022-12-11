package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeAtkLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(
        searchQuery: String,
        searchType: String,
        searchAtk: Int,
        searchLvl: Int
    ): List<Card> {


        return repository.searchCardsWithTypeAtkLvl(searchQuery, searchType, searchAtk, searchLvl)


    }
}