package com.example.mvvmexample.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardProvider @Inject constructor() {

        var cards:List<CardModel> = emptyList()
}