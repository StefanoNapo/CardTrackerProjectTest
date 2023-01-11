package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.data.database.entities.CompetitiveCollectionEntity
import javax.inject.Inject

class GetCardSearchCompCollUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String): List<CompetitiveCollectionEntity> {


        return repository.searchCardsNameCompColl(searchQuery)


    }

}