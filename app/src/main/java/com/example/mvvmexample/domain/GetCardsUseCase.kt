package com.example.mvvmexample.domain

import com.example.mvvmexample.data.CardRepository
import com.example.mvvmexample.data.model.CardModel
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val repository: CardRepository){

    suspend operator fun invoke():List<CardModel>? = repository.getAllCards()

}