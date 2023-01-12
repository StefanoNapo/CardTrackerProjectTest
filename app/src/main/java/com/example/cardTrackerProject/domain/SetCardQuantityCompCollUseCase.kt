package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import javax.inject.Inject

class SetCardQuantityCompCollUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(cardName: String, cardQuantity: Int) {

        repository.setCardQuantityCompColl(cardName, cardQuantity)

    }

}