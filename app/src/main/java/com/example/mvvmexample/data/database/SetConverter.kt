package com.example.mvvmexample.data.database

import androidx.room.TypeConverter
import com.example.mvvmexample.data.model.CardSet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SetConverter {

    @TypeConverter
    fun fromCardSetList(cardSet: List<CardSet?>?): String? {
        val gson = Gson()
        val type =
            object : TypeToken<List<CardSet?>?>() {}.type
        return gson.toJson(cardSet, type)
    }


    @TypeConverter
    fun toCardSetList(cardSetString: String?): List<CardSet>? {
        val gson = Gson()
        val type =
            object : TypeToken<List<CardSet?>?>() {}.type
        return gson.fromJson<List<CardSet>>(cardSetString, type)
    }


}