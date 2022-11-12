package com.example.cardTrackerProject.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cardTrackerProject.data.database.entities.CardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {

    @Query("SELECT * FROM card_table ORDER BY name ASC")
    suspend fun getAllCards(): List<CardEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cards: List<CardEntity>)

    @Query("DELETE FROM card_table")
    suspend fun deleteAllCards()

    @Query("SELECT * FROM card_table WHERE name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%' ORDER BY name ASC")
    suspend fun searchCardsNameAndText(searchQuery: String): List<CardEntity>


}