package com.example.cardTrackerProject.domain

import com.example.cardTrackerProject.data.CardRepository
import javax.inject.Inject

class DeleteCardMyCollUseCase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(cardName: String) {

        repository.deleteCardMyColl(cardName)

    }

}