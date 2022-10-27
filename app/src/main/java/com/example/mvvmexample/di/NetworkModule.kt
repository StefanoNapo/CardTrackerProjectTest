package com.example.mvvmexample.di

import com.example.mvvmexample.data.network.CardApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/StefanoNapo/ApiTest/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCardApiClient(retrofit: Retrofit):CardApiClient{
        return retrofit.create(CardApiClient::class.java)
    }
}