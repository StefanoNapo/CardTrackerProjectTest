package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchAttrAtkLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, searchAttr: String, searchAtk: Int, searchLvl: Int): List<Card> {


        return repository.searchCardsWithAttrAtkLvl(searchQuery, searchAttr, searchAtk, searchLvl)


    }
}