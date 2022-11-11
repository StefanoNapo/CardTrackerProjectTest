package com.example.cardTrackerProject.data.database

import androidx.room.TypeConverter
import com.example.cardTrackerProject.data.model.CardPrice
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PriceConverter {

    @TypeConverter
    fun fromCardPriceList(cardPrice: List<CardPrice?>?): String? {
        val gson = Gson()
        val type =
            object : TypeToken<List<CardPrice?>?>() {}.type
        return gson.toJson(cardPrice, type)
    }

    @TypeConverter
    fun toCardPriceList(cardPriceString: String?): List<CardPrice>? {
        val gson = Gson()
        val type =
            object : TypeToken<List<CardPrice?>?>() {}.type
        return gson.fromJson<List<CardPrice>>(cardPriceString, type)
    }

}