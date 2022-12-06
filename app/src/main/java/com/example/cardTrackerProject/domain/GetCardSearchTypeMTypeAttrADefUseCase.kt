package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeMTypeAttrADefUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, searchType: String, monsType: String, searchAttr: String, searchDef: Int): List<Card> {


        return repository.searchCardsWithTypeMonTypeAttrDef(searchQuery, searchType, monsType, searchAttr, searchDef)


    }
}