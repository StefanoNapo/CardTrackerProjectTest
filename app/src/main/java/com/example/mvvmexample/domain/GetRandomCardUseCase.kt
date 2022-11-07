package com.example.mvvmexample.domain

import com.example.mvvmexample.data.CardRepository
import com.example.mvvmexample.domain.model.Card
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