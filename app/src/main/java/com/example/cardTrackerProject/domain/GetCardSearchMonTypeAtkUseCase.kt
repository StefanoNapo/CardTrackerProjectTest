package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchMonTypeAtkUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, monsType: String, searchAtk: Int): List<Card> {


        return repository.searchCardsNameWithMonTypeAtk(searchQuery, monsType, searchAtk)


    }
}