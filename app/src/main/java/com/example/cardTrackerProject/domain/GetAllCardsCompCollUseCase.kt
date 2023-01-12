package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.CardTrackerProject
import com.example.cardTrackerProject.data.CardRepository
import javax.inject.Inject

class GetAllCardsCompCollUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke() {

        CardTrackerProject.cardListCompColl = repository.getAllCardsCompColl()

    }

}