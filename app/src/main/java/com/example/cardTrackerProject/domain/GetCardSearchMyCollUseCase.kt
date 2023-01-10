package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.data.database.entities.MyCollectionEntity
import javax.inject.Inject

class GetCardSearchMyCollUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String): List<MyCollectionEntity> {


        return repository.searchCardsNameMyColl(searchQuery)


    }

}