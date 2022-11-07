package com.example.mvvmexample.data

import com.example.mvvmexample.data.database.dao.CardDao
import com.example.mvvmexample.data.database.entities.CardEntity
import com.example.mvvmexample.data.model.CardModel
import com.example.mvvmexample.data.network.CardService
import com.example.mvvmexample.domain.model.Card
import com.example.mvvmexample.domain.model.toDomain
import javax.inject.Inject

class CardRepository @Inject constructor(private val api : CardService, private val cardDao: CardDao) {

    suspend fun getAllCardsFromApi():List<Card>{
        val response : List<CardModel> = api.getCards()
        return response.map { it.toDomain() }
    }

    suspend fun getAllCardsFromDatabase():List<Card>{
        val response = cardDao.getAllCards()
        return response.map { it.toDomain() }
    }

    suspend fun insertCards(cards:List<CardEntity>){
        cardDao.insertAll(cards)
    }

    suspend fun clearCards(){
        cardDao.deleteAllCards()
    }

}