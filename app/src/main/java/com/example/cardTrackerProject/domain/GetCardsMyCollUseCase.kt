package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.data.database.entities.MyCollectionEntity
import javax.inject.Inject

class GetCardsMyCollUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(listOfCards : MutableList<MyCollectionEntity>) {

        if(listOfCards.isNotEmpty()) repository.insertCardsMyColl(listOfCards)

    }

}