package com.example.mvvmexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmexample.data.database.dao.CardDao
import com.example.mvvmexample.data.database.entities.CardEntity

@Database(entities = [CardEntity::class], version = 1)
@TypeConverters()
abstract class CardDatabase : RoomDatabase(){

    abstract fun getCardDao():CardDao

}