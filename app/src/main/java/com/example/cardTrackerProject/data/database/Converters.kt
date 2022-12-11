package com.example.cardTrackerProject.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {

    @TypeConverter
    fun fromStringList(stringList: List<String?>?): String? {
        val gson = Gson()
        return gson.toJson(stringList)
    }

    @TypeConverter
    fun toStringList(value: String?): List<String?>? {
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }


}