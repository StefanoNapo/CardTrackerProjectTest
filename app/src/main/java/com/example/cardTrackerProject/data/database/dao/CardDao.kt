package com.example.cardTrackerProject.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cardTrackerProject.data.database.entities.CardEntity

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

    @Query("SELECT * FROM card_table WHERE (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithType(searchQuery: String, searchType: String): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithMonType(searchQuery: String, monsType: String): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithAttr(searchQuery: String, searchAttr: String): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithAtk(searchQuery: String, searchAtk: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithDef(searchQuery: String, searchDef: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithLvl(searchQuery: String, searchLvl: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithTypeMonType(searchQuery: String, searchType: String, monsType: String):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithTypeAttr(searchQuery: String, searchType: String, searchAttr: String):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithMonTypeAttr(searchQuery: String, monsType: String, searchAttr: String):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithTypeAttrMonType(searchQuery: String, searchType: String, searchAttr: String, monsType: String): List<CardEntity>


}