package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.data.database.entities.ForSaleCollectionEntity
import javax.inject.Inject

class GetCardsForSaleUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(listOfCards : MutableList<ForSaleCollectionEntity>) {

        if(listOfCards.isNotEmpty()) repository.insertCardsForSale(listOfCards)

    }

}