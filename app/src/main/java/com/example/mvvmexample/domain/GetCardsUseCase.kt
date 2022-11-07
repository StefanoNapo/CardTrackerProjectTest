package com.example.mvvmexample.domain

import com.example.mvvmexample.data.CardRepository
import com.example.mvvmexample.data.database.entities.toDatabase
import com.example.mvvmexample.domain.model.Card
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val repository: CardRepository){

    suspend operator fun invoke(): List<Card> {
        val cards = repository.getAllCardsFromApi()

        return if(cards.isNotEmpty()){
            repository.clearCards()
            repository.insertCards(cards.map { it.toDatabase() })
            cards
        }else{
            repository.getAllCardsFromDatabase()
        }
    }

}