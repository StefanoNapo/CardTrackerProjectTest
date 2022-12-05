package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchAttrAtkDefUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, searchAttr: String, searchAtk: Int, searchDef: Int): List<Card> {


        return repository.searchCardsWithAttrAtkDef(searchQuery, searchAttr, searchAtk, searchDef)


    }
}