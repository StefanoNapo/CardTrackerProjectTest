package com.example.cardTrackerProject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cardTrackerProject.data.database.dao.CardDao
import com.example.cardTrackerProject.data.database.entities.CardEntity
import com.example.cardTrackerProject.data.database.entities.CompetitiveCollectionEntity
import com.example.cardTrackerProject.data.database.entities.ForSaleCollectionEntity
import com.example.cardTrackerProject.data.database.entities.MyCollectionEntity

@Database(entities = [CardEntity::class, CompetitiveCollectionEntity::class, ForSaleCollectionEntity::class, MyCollectionEntity::class], version = 1)
@TypeConverters()
abstract class CardDatabase : RoomDatabase(){

    abstract fun getCardDao():CardDao

}