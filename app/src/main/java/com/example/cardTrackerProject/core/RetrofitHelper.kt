package com.example.cardTrackerProject.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {


    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/StefanoNapo/ApiTest/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}