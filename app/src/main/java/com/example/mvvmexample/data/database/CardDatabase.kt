package com.example.mvvmexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmexample.data.database.dao.CardDao
import com.example.mvvmexample.data.database.entities.CardEntity
import com.example.mvvmexample.data.database.entities.CardImageEntity
import com.example.mvvmexample.data.database.entities.CardPriceEntity
import com.example.mvvmexample.data.database.entities.CardSetEntity

@Database(entities = [CardEntity::class, CardSetEntity::class, CardImageEntity::class, CardPriceEntity::class], version = 1)
abstract class CardDatabase : RoomDatabase(){

    abstract fun getCardDao():CardDao

}