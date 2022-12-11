package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchAttrAtkUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(
        searchQuery: String,
        searchAttr: String,
        searchAtk: Int
    ): List<Card> {


        return repository.searchCardsNameWithAttrAtk(searchQuery, searchAttr, searchAtk)

    }
}