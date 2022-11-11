package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetRandomCardUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke():Card?{
        val cards = repository.getAllCardsFromDatabase()
        if (!cards.isNullOrEmpty()){
            val randomNumber = (cards.indices).random()
            return cards[randomNumber]
        }
        return null
    }
}