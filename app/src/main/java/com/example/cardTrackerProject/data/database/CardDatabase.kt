package com.example.cardTrackerProject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cardTrackerProject.data.database.dao.CardDao
import com.example.cardTrackerProject.data.database.entities.CardEntity

@Database(entities = [CardEntity::class], version = 1)
@TypeConverters()
abstract class CardDatabase : RoomDatabase(){

    abstract fun getCardDao():CardDao

}