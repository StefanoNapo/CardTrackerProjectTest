package com.example.cardTrackerProject.data.database.dao

import androidx.room.*
import com.example.cardTrackerProject.data.database.entities.CardEntity
import com.example.cardTrackerProject.data.database.entities.CompetitiveCollectionEntity
import com.example.cardTrackerProject.data.database.entities.ForSaleCollectionEntity
import com.example.cardTrackerProject.data.database.entities.MyCollectionEntity

@Dao
interface CardDao {

    @Query("SELECT * FROM card_table ORDER BY name ASC")
    suspend fun getAllCards(): List<CardEntity>

    @Query("SELECT * FROM my_collection ORDER BY name ASC")
    suspend fun getAllCardsMyColl(): List<MyCollectionEntity>

    @Query("SELECT * FROM for_sale_collection ORDER BY name ASC")
    suspend fun getAllCardsForSaleColl(): List<ForSaleCollectionEntity>

    @Query("SELECT * FROM competitive_collection ORDER BY name ASC")
    suspend fun getAllCardsCompColl(): List<CompetitiveCollectionEntity>

    //Updates to set new amount of cards on each collection
    @Query("UPDATE my_collection SET quantity=:cardQuantity WHERE name=:cardName")
    suspend fun setCardQuantityMyColl(cardName: String, cardQuantity: Int)

    @Query("UPDATE for_sale_collection SET quantity=:cardQuantity WHERE name=:cardName")
    suspend fun setCardQuantityForSaleColl(cardName: String, cardQuantity: Int)

    @Query("UPDATE competitive_collection SET quantity=:cardQuantity WHERE name=:cardName")
    suspend fun setCardQuantityCompColl(cardName: String, cardQuantity: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cards: List<CardEntity>)

    @Query("DELETE FROM card_table")
    suspend fun deleteAllCards()

    //Card deletes for every collection with the deleteButton.OnClickListener
    @Query("DELETE FROM my_collection WHERE name=:cardName")
    suspend fun deleteCardMyColl(cardName: String)

    @Query("DELETE FROM for_sale_collection WHERE name=:cardName")
    suspend fun deleteCardForSaleColl(cardName: String)

    @Query("DELETE FROM competitive_collection WHERE name=:cardName")
    suspend fun deleteCardCompColl(cardName: String)

    //Queries for the cardSearchView
    @Query("SELECT * FROM card_table WHERE name LIKE :searchQuery ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsOnlyName(searchQuery: String): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%' ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsNameAndText(searchQuery: String): List<CardEntity>

    @Query("SELECT * FROM my_collection WHERE name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%' ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsNameMyColl(searchQuery: String): List<MyCollectionEntity>

    @Query("SELECT * FROM competitive_collection WHERE name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%' ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsNameCompColl(searchQuery: String): List<CompetitiveCollectionEntity>

    @Query("SELECT * FROM for_sale_collection WHERE name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%' ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsNameForSaleColl(searchQuery: String): List<ForSaleCollectionEntity>


    @Query("SELECT * FROM card_table WHERE (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsWithType(searchQuery: String, searchType: String): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsWithMonType(searchQuery: String, monsType: String): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsWithAttr(searchQuery: String, searchAttr: String): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsWithAtk(searchQuery: String, searchAtk: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsWithDef(searchQuery: String, searchDef: Int): List<CardEntity>

    @Query("SELECT * FROM card_table WHERE (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC")
    suspend fun searchCardsWithLvl(searchQuery: String, searchLvl: Int): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonType(
        searchQuery: String,
        searchType: String,
        monsType: String
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAttr(
        searchQuery: String,
        searchType: String,
        searchAttr: String
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAttr(
        searchQuery: String,
        monsType: String,
        searchAttr: String
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAtk(
        searchQuery: String,
        searchType: String,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeDef(
        searchQuery: String,
        searchType: String,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (level = :searchLvl) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeLvl(
        searchQuery: String,
        searchType: String,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (atk = :searchAtk) AND (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAtk(
        searchQuery: String,
        monsType: String,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeDef(
        searchQuery: String,
        monsType: String,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (level = :searchLvl) AND (race = :monsType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeLvl(
        searchQuery: String,
        monsType: String,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAttrAtk(
        searchQuery: String,
        searchAttr: String,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAttrDef(
        searchQuery: String,
        searchAttr: String,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAttrLvl(
        searchQuery: String,
        searchAttr: String,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAtkDef(
        searchQuery: String,
        searchDef: Int,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (level = :searchLvl) AND (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAtkLvl(
        searchQuery: String,
        searchLvl: Int,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') " +
                "ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithDefLvl(
        searchQuery: String,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAttrMonType(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeAtk(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (def = :searchDef) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeDef(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (level = :searchLvl) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeLvl(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAttrAtk(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (def = :searchDef) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAttrDef(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (level = :searchLvl) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAttrLvl(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAtkDef(
        searchQuery: String,
        searchType: String,
        searchAtk: Int,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (level = :searchLvl) AND (atk = :searchAtk) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAtkLvl(
        searchQuery: String,
        searchType: String,
        searchAtk: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (level = :searchLvl) AND (def = :searchDef) AND (type = :searchType) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeDefLvl(
        searchQuery: String,
        searchType: String,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (atk = :searchAtk) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAttrAtk(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAttrDef(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAttrLvl(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (atk = :searchAtk) AND (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAtkDef(
        searchQuery: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (atk = :searchAtk) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAtkLvl(
        searchQuery: String,
        monsType: String,
        searchAtk: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (def = :searchDef) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeDefLvl(
        searchQuery: String,
        monsType: String,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (atk = :searchAtk) AND (def = :searchDef) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAttrAtkDef(
        searchQuery: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (atk = :searchAtk) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAttrAtkLvl(
        searchQuery: String,
        searchAttr: String,
        searchAtk: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (def = :searchDef) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAttrDefLvl(
        searchQuery: String,
        searchAttr: String,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (atk = :searchAtk) AND (def = :searchDef) AND (level = :searchLvl) AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%')" +
                " ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAtkDefLvl(
        searchQuery: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (race = :monsType) AND (attribute = :searchAttr) AND (atk = :searchAtk) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeAttrAtk(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (race = :monsType) AND (attribute = :searchAttr) AND (def = :searchDef) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeAttrDef(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAttr: String,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (race = :monsType) AND (attribute = :searchAttr) AND (level = :searchLvl) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeAttrLvl(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAttr: String,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (race = :monsType) AND (atk = :searchAtk) AND (def = :searchDef) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeAtkDef(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (race = :monsType) AND (atk = :searchAtk) AND (level = :searchLvl) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeAtkLvl(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAtk: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (race = :monsType) AND (def = :searchDef) AND (level = :searchLvl) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeMonTypeDefLvl(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (attribute = :searchAttr) AND (atk = :searchAtk) AND (def = :searchDef)" +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAttrAtkDef(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (attribute = :searchAttr) AND (atk = :searchAtk) AND (level = :searchLvl)" +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAttrAtkLvl(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchAtk: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (attribute = :searchAttr) AND (def = :searchDef) AND (level = :searchLvl)" +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAttrDefLvl(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (type = :searchType) AND (atk = :searchAtk) AND (def = :searchDef) AND (level = :searchLvl)" +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTypeAtkDefLvl(
        searchQuery: String,
        searchType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (atk = :searchAtk) AND (def = :searchDef) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAttrAtkDef(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (atk = :searchAtk) AND (level = :searchLvl) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAttrAtkLvl(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (attribute = :searchAttr) AND (def = :searchDef) AND (level = :searchLvl) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAttrDefLvl(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (race = :monsType) AND (atk = :searchAtk) AND (def = :searchDef) AND (level = :searchLvl) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMonTypeAtkDefLvl(
        searchQuery: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (attribute = :searchAttr) AND (atk = :searchAtk) AND (def = :searchDef) AND (level = :searchLvl) " +
                "AND (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithAttrAtkDefLvl(
        searchQuery: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (atk = :searchAtk) AND (def = :searchDef) AND (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND" +
                " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTAMTAtkD(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (atk = :searchAtk) AND (level = :searchLvl) AND (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND" +
                " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTAMTAtkL(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String,
        searchAtk: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (level = :searchLvl) AND (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND" +
                " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTAMTDL(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (level = :searchLvl) AND (atk = :searchAtk) AND (attribute = :searchAttr) AND (type = :searchType) AND" +
                " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTAAtkDL(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (level = :searchLvl) AND (atk = :searchAtk) AND (race = :monsType) AND (type = :searchType) AND" +
                " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTMTAtkDL(
        searchQuery: String,
        searchType: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (def = :searchDef) AND (level = :searchLvl) AND (atk = :searchAtk) AND (race = :monsType) AND (attribute = :searchAttr) AND" +
                " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithMTAAtkDL(
        searchQuery: String,
        monsType: String,
        searchAttr: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>

    @Query(
        "SELECT * FROM card_table WHERE (atk = :searchAtk) AND (def = :searchDef) AND (level = :searchLvl) AND (race = :monsType) AND (attribute = :searchAttr) AND (type = :searchType) AND" +
                " (name LIKE '%' || :searchQuery || '%' OR `desc` LIKE '%' || :searchQuery || '%') ORDER BY level DESC, linkval DESC, type ASC"
    )
    suspend fun searchCardsWithTAMTAtkDL(
        searchQuery: String,
        searchType: String,
        searchAttr: String,
        monsType: String,
        searchAtk: Int,
        searchDef: Int,
        searchLvl: Int
    ): List<CardEntity>


    //Inserts for listing cards into the collections

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardsInCompColl(cards: List<CompetitiveCollectionEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardsInForSaleColl(cards: List<ForSaleCollectionEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardsInMyColl(cards: List<MyCollectionEntity>)

}