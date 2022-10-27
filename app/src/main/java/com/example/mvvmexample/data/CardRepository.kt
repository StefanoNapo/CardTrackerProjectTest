package com.example.mvvmexample.data

import com.example.mvvmexample.data.model.CardModel
import com.example.mvvmexample.data.model.CardProvider
import com.example.mvvmexample.data.network.CardService
import javax.inject.Inject

class CardRepository @Inject constructor(private val api : CardService, private val cardProvider: CardProvider) {

    suspend fun getAllCards():List<CardModel>{
        val response = api.getCards()
        cardProvider.cards = response
        return response
    }
}