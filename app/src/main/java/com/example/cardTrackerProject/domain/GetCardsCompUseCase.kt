package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.data.database.entities.CompetitiveCollectionEntity
import javax.inject.Inject

class GetCardsCompUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(listOfCards : MutableList<CompetitiveCollectionEntity>) {

        if(listOfCards.isNotEmpty()) repository.insertCardsComp(listOfCards)

    }

}