package com.example.mvvmexample.domain

import com.example.mvvmexample.data.CardRepository
import com.example.mvvmexample.data.model.CardModel
import com.example.mvvmexample.data.model.CardProvider

class GetRandomCardUseCase {

    private val repository = CardRepository()

    operator fun invoke():CardModel?{
        val cards = CardProvider.cards
        if (!cards.isNullOrEmpty()){
            val randomNumber = (0..cards.size-1).random()
            return cards[randomNumber]
        }
        return null
    }
}