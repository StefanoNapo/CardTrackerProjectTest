package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import javax.inject.Inject

class SetCardQuantityMyCollUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(cardName: String, cardQuantity: Int) {

        repository.setCardQuantityMyColl(cardName, cardQuantity)

    }

}