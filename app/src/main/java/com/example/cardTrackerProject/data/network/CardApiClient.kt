package com.example.cardTrackerProject.data.network

import com.example.cardTrackerProject.data.model.CardModel
import retrofit2.Response
import retrofit2.http.GET

interface CardApiClient {

    @GET("cardlist.json")
    suspend fun getAllCards(): Response<List<CardModel>>


}