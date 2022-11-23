package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchMonTypeUseCase @Inject constructor(private val repository: CardRepository){

    suspend operator fun invoke(searchQuery : String, monsType: String): List<Card> {


        return repository.searchCardsNameWithMonType(searchQuery, monsType)



    }
}