package com.example.mvvmexample.data.network

import com.example.mvvmexample.core.RetrofitHelper
import com.example.mvvmexample.data.model.CardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class CardService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCards():List<CardModel>{
        return withContext(Dispatchers.IO) {

            val response = retrofit.create(CardApiClient::class.java).getAllCards()
            response.body() ?: emptyList()
        }
    }
}