package com.example.cardTrackerProject.domain.model

import com.example.cardTrackerProject.data.CardRepository
import javax.inject.Inject

class GetCardSearchAtkUseCase @Inject constructor(private val repository: CardRepository){

    suspend operator fun invoke(searchQuery: String, searchAtk: Int): List<Card> {


        return repository.searchCardsNameWithAtk(searchQuery, searchAtk)

    }
}