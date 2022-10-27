package com.example.mvvmexample.data.network

import com.example.mvvmexample.core.RetrofitHelper
import com.example.mvvmexample.data.model.CardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create
import javax.inject.Inject

class CardService @Inject constructor(private val api:CardApiClient) {

    suspend fun getCards():List<CardModel>{
        return withContext(Dispatchers.IO) {
            val response = api.getAllCards()
            response.body() ?: emptyList()
        }
    }
}