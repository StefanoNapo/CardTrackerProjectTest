package com.example.mvvmexample.data.database

import androidx.room.TypeConverter
import com.example.mvvmexample.data.model.CardImage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImageConverter {

    @TypeConverter
    fun fromCardImageList(cardImage: List<CardImage?>?): String? {
        val gson = Gson()
        val type =
            object : TypeToken<List<CardImage?>?>() {}.type
        return gson.toJson(cardImage, type)
    }

    @TypeConverter
    fun toCardImageList(cardImageString: String?): List<CardImage>? {
        val gson = Gson()
        val type =
            object : TypeToken<List<CardImage?>?>() {}.type
        return gson.fromJson<List<CardImage>>(cardImageString, type)
    }


}