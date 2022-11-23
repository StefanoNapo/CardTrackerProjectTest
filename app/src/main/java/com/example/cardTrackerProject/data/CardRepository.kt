package com.example.cardTrackerProject.data

import com.example.cardTrackerProject.data.database.dao.CardDao
import com.example.cardTrackerProject.data.database.entities.CardEntity
import com.example.cardTrackerProject.data.model.CardModel
import com.example.cardTrackerProject.data.network.CardService
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.domain.model.toDomain
import kotlinx.coroutines.flow.Flow
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

    suspend fun searchCardsNameAndText (searchQuery : String): List<Card>{
        val response = cardDao.searchCardsNameAndText(searchQuery)
        return response.map { it.toDomain() }

    }

    suspend fun searchCardsNameWithType (searchQuery : String, searchType: String): List<Card> {
        val response = cardDao.searchCardsWithType(searchQuery, searchType)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithTypeMonType (searchQuery: String, searchType: String, monsType: String): List<Card> {
        val response = cardDao.searchCardsWithTypeMonType(searchQuery, searchType, monsType)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAttrMonType (searchQuery: String, searchType: String, searchAttr: String, monsType: String): List<Card>{
        val response = cardDao.searchCardsWithTypeAttrMonType(searchQuery, searchType, searchAttr, monsType)
        return response.map { it.toDomain() }
    }

}