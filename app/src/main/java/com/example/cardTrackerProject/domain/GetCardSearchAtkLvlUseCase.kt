package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchAtkLvlUseCase @Inject constructor(private val repository: CardRepository){

    suspend operator fun invoke(searchQuery: String, searchLvl: Int, searchAtk: Int): List<Card> {


        return repository.searchCardsNameWithAtkLvl(searchQuery, searchLvl, searchAtk)

    }
}