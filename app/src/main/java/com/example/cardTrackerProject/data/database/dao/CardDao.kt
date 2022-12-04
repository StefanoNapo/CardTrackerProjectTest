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

    //Queries for the cardSearchView

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

    @Query("SELECT * FROM card_table WHERE (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithTypeAtk(searchQuery: String, searchType: String, searchAtk: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (def = :searchDef) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithTypeDef(searchQuery: String, searchType: String, searchDef: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (level = :searchLvl) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithTypeLvl(searchQuery: String, searchType: String, searchLvl: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (atk = :searchAtk) AND (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithMonTypeAtk(searchQuery: String, monsType: String, searchAtk: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (def = :searchDef) AND (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithMonTypeDef(searchQuery: String, monsType: String, searchDef: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (level = :searchLvl) AND (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithMonTypeLvl(searchQuery: String, monsType: String, searchLvl: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithAttrAtk(searchQuery: String, searchAttr: String, searchAtk: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithAttrDef(searchQuery: String, searchAttr: String, searchDef: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithAttrLvl(searchQuery: String, searchAttr: String, searchLvl: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (def = :searchDef) AND (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithAtkDef(searchQuery: String, searchDef: Int, searchAtk: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (level = :searchLvl) AND (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithAtkLvl(searchQuery: String, searchLvl: Int, searchAtk: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (def = :searchDef) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithDefLvl(searchQuery: String, searchDef: Int, searchLvl: Int):List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeAttrMonType(searchQuery: String, searchType: String, searchAttr: String, monsType: String): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeMonTypeAtk(searchQuery: String, searchType: String, monsType: String, searchAtk: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (def = :searchDef) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeMonTypeDef(searchQuery: String, searchType: String, monsType: String, searchDef: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (level = :searchLvl) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeMonTypeLvl(searchQuery: String, searchType: String, monsType: String, searchLvl: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeAttrAtk(searchQuery: String, searchType: String, searchAttr: String, searchAtk: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (def = :searchDef) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeAttrDef(searchQuery: String, searchType: String, searchAttr: String, searchDef: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (level = :searchLvl) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeAttrLvl(searchQuery: String, searchType: String, searchAttr: String, searchLvl: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (def = :searchDef) AND (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeAtkDef(searchQuery: String, searchType: String, searchAtk: Int, searchDef: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (level = :searchLvl) AND (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeAtkLvl(searchQuery: String, searchType: String, searchAtk: Int, searchLvl: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (level = :searchLvl) AND (def = :searchDef) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithTypeDefLvl(searchQuery: String, searchType: String, searchDef: Int, searchLvl: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithMonTypeAttrAtk(searchQuery: String, monsType: String, searchAttr: String, searchAtk: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithMonTypeAttrDef(searchQuery: String, monsType: String, searchAttr: String, searchDef: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithMonTypeAttrLvl(searchQuery: String, monsType: String, searchAttr: String, searchLvl: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (atk = :searchAtk) AND (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
            " ORDER BY name ASC")
    suspend fun searchCardsWithMonTypeAtkDef(searchQuery: String, monsType: String, searchAtk: Int, searchDef: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (atk = :searchAtk) AND (def = :searchDef) AND (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND" +
            " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithTAMTAtkD(searchQuery: String, searchType: String, searchAttr: String, monsType: String, searchAtk: Int, searchDef: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (atk = :searchAtk) AND (def = :searchDef) AND (level = :searchLvl) AND (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND" +
            " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY name ASC")
    suspend fun searchCardsWithTAMTAtkDL(searchQuery: String, searchType: String, searchAttr: String, monsType: String, searchAtk: Int, searchDef: Int, searchLvl: Int): List<CardEntity>

}