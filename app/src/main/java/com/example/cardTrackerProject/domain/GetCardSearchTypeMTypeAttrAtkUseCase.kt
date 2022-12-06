package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeMTypeAttrAtkUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, searchType: String, monsType: String, searchAttr: String, searchAtk: Int): List<Card> {


        return repository.searchCardsWithTypeMonTypeAttrAtk(searchQuery, searchType, monsType, searchAttr, searchAtk)


    }
}