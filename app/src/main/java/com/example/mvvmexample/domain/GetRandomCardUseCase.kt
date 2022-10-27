package com.example.mvvmexample.domain

import com.example.mvvmexample.data.CardRepository
import com.example.mvvmexample.data.model.CardModel
import com.example.mvvmexample.data.model.CardProvider
import javax.inject.Inject

class GetRandomCardUseCase @Inject constructor(private val cardProvider: CardProvider) {

    operator fun invoke():CardModel?{
        val cards = cardProvider.cards
        if (!cards.isNullOrEmpty()){
            val randomNumber = (0..cards.size-1).random()
            return cards[randomNumber]
        }
        return null
    }
}