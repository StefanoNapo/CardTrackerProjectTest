package com.example.cardTrackerProject.domain

import android.widget.Toast
import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.data.database.entities.toDatabase
import com.example.cardTrackerProject.domain.model.Card
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(): List<Card> {
        val cards = repository.getAllCardsFromApi()

        return if (cards.isNotEmpty()) {
            repository.clearCards()
            repository.insertCards(cards.map { it.toDatabase() })
            cards
        } else {
            repository.getAllCardsFromDatabase()
        }

    }

}