package com.example.mvvmexample.data

import com.example.mvvmexample.data.model.CardModel
import com.example.mvvmexample.data.model.CardProvider
import com.example.mvvmexample.data.network.CardService

class CardRepository {

    private val api = CardService()

    suspend fun getAllCards():List<CardModel>{
        val response = api.getCards()
        CardProvider.cards = response
        return response
    }
}