package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardSearchTypeAttrAtkLvlUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(searchQuery: String, searchType: String, searchAttr: String, searchAtk: Int, searchLvl: Int): List<Card> {


        return repository.searchCardsWithTypeAttrAtkLvl(searchQuery, searchType, searchAttr, searchAtk, searchLvl)


    }
}