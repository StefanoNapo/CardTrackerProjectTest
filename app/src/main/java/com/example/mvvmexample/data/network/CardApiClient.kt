package com.example.mvvmexample.data.network

import com.example.mvvmexample.data.model.CardModel
import retrofit2.Response
import retrofit2.http.GET

interface CardApiClient {

    @GET("cardlist.json")
    suspend fun getAllCards():Response <List<CardModel>>



}