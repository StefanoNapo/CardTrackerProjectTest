package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.data.database.entities.ForSaleCollectionEntity

import javax.inject.Inject

class GetCardSearchForSaleCollUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String): List<ForSaleCollectionEntity> {


        return repository.searchCardsNameForSaleColl(searchQuery)


    }

}