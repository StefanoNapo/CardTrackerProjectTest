package com.example.cardTrackerProject.data

import com.example.cardTrackerProject.data.database.dao.CardDao
import com.example.cardTrackerProject.data.database.entities.CardEntity
import com.example.cardTrackerProject.data.model.CardModel
import com.example.cardTrackerProject.data.network.CardService
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.domain.model.toDomain
import javax.inject.Inject

class CardRepository @Inject constructor(private val api : CardService, private val cardDao: CardDao) {

    suspend fun getAllCardsFromApi():List<Card>{
        val response : List<CardModel> = api.getCards()
        return response.map { it.toDomain() }
    }

    suspend fun getAllCardsFromDatabase():List<Card>{
        val response = cardDao.getAllCards()
        return response.map { it.toDomain() }
    }

    suspend fun insertCards(cards:List<CardEntity>){
        cardDao.insertAll(cards)
    }

    suspend fun clearCards(){
        cardDao.deleteAllCards()
    }

    suspend fun searchCardsNameAndText (searchQuery : String): List<Card>{
        val response = cardDao.searchCardsNameAndText(searchQuery)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithType (searchQuery : String, searchType: String): List<Card> {
        val response = cardDao.searchCardsWithType(searchQuery, searchType)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithMonType (searchQuery : String, monsType: String): List<Card> {
        val response = cardDao.searchCardsWithMonType(searchQuery, monsType)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithAttr (searchQuery: String, searchAttr: String): List<Card> {
        val response = cardDao.searchCardsWithAttr(searchQuery, searchAttr)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithAtk (searchQuery: String, searchAtk: Int): List<Card> {
        val response = cardDao.searchCardsWithAtk(searchQuery, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithDef (searchQuery: String, searchDef: Int): List<Card> {
        val response = cardDao.searchCardsWithDef(searchQuery, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithLvl (searchQuery: String, searchLvl: Int): List<Card> {
        val response = cardDao.searchCardsWithLvl(searchQuery, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithTypeMonType (searchQuery: String, searchType: String, monsType: String): List<Card> {
        val response = cardDao.searchCardsWithTypeMonType(searchQuery, searchType, monsType)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithTypeAttr (searchQuery: String, searchType: String, searchAttr: String): List<Card> {
        val response = cardDao.searchCardsWithTypeAttr(searchQuery, searchType, searchAttr)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithMonTypeAttr (searchQuery: String, monsType: String, searchAttr: String): List<Card> {
        val response = cardDao.searchCardsWithMonTypeAttr(searchQuery, monsType, searchAttr)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithTypeAtk (searchQuery: String, searchType: String, searchAtk: Int): List<Card> {
        val response = cardDao.searchCardsWithTypeAtk(searchQuery, searchType, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithTypeDef (searchQuery: String, searchType: String, searchDef: Int): List<Card> {
        val response = cardDao.searchCardsWithTypeDef(searchQuery, searchType, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithTypeLvl (searchQuery: String, searchType: String, searchLvl: Int): List<Card> {
        val response = cardDao.searchCardsWithTypeLvl(searchQuery, searchType, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithMonTypeAtk (searchQuery: String, monsType: String, searchAtk: Int): List<Card> {
        val response = cardDao.searchCardsWithMonTypeAtk(searchQuery, monsType, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithMonTypeDef (searchQuery: String, monsType: String, searchDef: Int): List<Card> {
        val response = cardDao.searchCardsWithMonTypeDef(searchQuery, monsType, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithMonTypeLvl (searchQuery: String, monsType: String, searchLvl: Int): List<Card> {
        val response = cardDao.searchCardsWithMonTypeLvl(searchQuery, monsType, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithAttrAtk (searchQuery: String, searchAttr: String, searchAtk: Int): List<Card> {
        val response = cardDao.searchCardsWithAttrAtk(searchQuery, searchAttr, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithAttrDef (searchQuery: String, searchAttr: String, searchDef: Int): List<Card> {
        val response = cardDao.searchCardsWithAttrDef(searchQuery, searchAttr, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithAttrLvl (searchQuery: String, searchAttr: String, searchLvl: Int): List<Card> {
        val response = cardDao.searchCardsWithAttrLvl(searchQuery, searchAttr, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithAtkDef (searchQuery: String, searchDef: Int, searchAtk: Int): List<Card> {
        val response = cardDao.searchCardsWithAtkDef(searchQuery, searchDef, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithAtkLvl (searchQuery: String, searchLvl: Int, searchAtk: Int): List<Card> {
        val response = cardDao.searchCardsWithAtkLvl(searchQuery, searchLvl, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsNameWithDefLvl (searchQuery: String, searchDef: Int, searchLvl: Int): List<Card> {
        val response = cardDao.searchCardsWithDefLvl(searchQuery, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAttrMonType (searchQuery: String, searchType: String, searchAttr: String, monsType: String): List<Card>{
        val response = cardDao.searchCardsWithTypeAttrMonType(searchQuery, searchType, searchAttr, monsType)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeMonTypeAtk (searchQuery: String, searchType: String, monsType: String, searchAtk: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeMonTypeAtk(searchQuery, searchType, monsType, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeMonTypeDef (searchQuery: String, searchType: String, monsType: String, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeMonTypeDef(searchQuery, searchType, monsType, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeMonTypeLvl (searchQuery: String, searchType: String, monsType: String, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeMonTypeLvl(searchQuery, searchType, monsType, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAttrAtk (searchQuery: String, searchType: String, searchAttr: String, searchAtk: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAttrAtk(searchQuery, searchType, searchAttr, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAttrDef (searchQuery: String, searchType: String, searchAttr: String, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAttrDef(searchQuery, searchType, searchAttr, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAttrLvl (searchQuery: String, searchType: String, searchAttr: String, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAttrLvl(searchQuery, searchType, searchAttr, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAtkDef (searchQuery: String, searchType: String, searchAtk: Int, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAtkDef(searchQuery, searchType, searchAtk, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAtkLvl (searchQuery: String, searchType: String, searchAtk: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAtkLvl(searchQuery, searchType, searchAtk, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeDefLvl (searchQuery: String, searchType: String, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeDefLvl(searchQuery, searchType, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAttrAtk (searchQuery: String, monsType: String, searchAttr: String, searchAtk: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAttrAtk(searchQuery, monsType, searchAttr, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAttrDef (searchQuery: String, monsType: String, searchAttr: String, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAttrDef(searchQuery, monsType, searchAttr, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAttrLvl (searchQuery: String, monsType: String, searchAttr: String, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAttrLvl(searchQuery, monsType, searchAttr, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAtkDef (searchQuery: String, monsType: String, searchAtk: Int, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAtkDef(searchQuery, monsType, searchAtk, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAtkLvl (searchQuery: String, monsType: String, searchAtk: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAtkLvl(searchQuery, monsType, searchAtk, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeDefLvl (searchQuery: String, monsType: String, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeDefLvl(searchQuery, monsType, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithAttrAtkDef (searchQuery: String, searchAttr: String, searchAtk: Int, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithAttrAtkDef(searchQuery, searchAttr, searchAtk, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithAttrAtkLvl (searchQuery: String, searchAttr: String, searchAtk: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithAttrAtkLvl(searchQuery, searchAttr, searchAtk, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithAttrDefLvl (searchQuery: String, searchAttr: String, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithAttrDefLvl(searchQuery, searchAttr, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithAtkDefLvl (searchQuery: String, searchAtk: Int, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithAtkDefLvl(searchQuery, searchAtk, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeMonTypeAttrAtk (searchQuery: String, searchType: String, monsType: String, searchAttr: String, searchAtk: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeMonTypeAttrAtk(searchQuery, searchType, monsType, searchAttr, searchAtk)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeMonTypeAttrDef (searchQuery: String, searchType: String, monsType: String, searchAttr: String, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeMonTypeAttrDef(searchQuery, searchType, monsType, searchAttr, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeMonTypeAttrLvl (searchQuery: String, searchType: String, monsType: String, searchAttr: String, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeMonTypeAttrLvl(searchQuery, searchType, monsType, searchAttr, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAttrAtkDef (searchQuery: String, searchType: String, searchAttr: String, searchAtk: Int, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAttrAtkDef(searchQuery, searchType, searchAttr, searchAtk, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAttrAtkLvl (searchQuery: String, searchType: String, searchAttr: String, searchAtk: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAttrAtkLvl(searchQuery, searchType, searchAttr, searchAtk, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAttrDefLvl (searchQuery: String, searchType: String, searchAttr: String, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAttrDefLvl(searchQuery, searchType, searchAttr, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTypeAtkDefLvl (searchQuery: String, searchType: String, searchAtk: Int, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTypeAtkDefLvl(searchQuery, searchType, searchAtk, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAttrAtkDef (searchQuery: String, monsType: String, searchAttr: String, searchAtk: Int, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAttrAtkDef(searchQuery, monsType, searchAttr, searchAtk, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAttrAtkLvl (searchQuery: String, monsType: String, searchAttr: String, searchAtk: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAttrAtkLvl(searchQuery, monsType, searchAttr, searchAtk, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAttrDefLvl (searchQuery: String, monsType: String, searchAttr: String, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAttrDefLvl(searchQuery, monsType, searchAttr, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithMonTypeAtkDefLvl (searchQuery: String, monsType: String, searchAtk: Int, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithMonTypeAtkDefLvl(searchQuery, monsType, searchAtk, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithAttrAtkDefLvl (searchQuery: String, searchAttr: String, searchAtk: Int, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithAttrAtkDefLvl(searchQuery, searchAttr, searchAtk, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTAMTAtkD (searchQuery: String, searchType: String, searchAttr: String, monsType: String, searchAtk: Int, searchDef: Int): List<Card>{
        val response = cardDao.searchCardsWithTAMTAtkD(searchQuery, searchType, searchAttr, monsType, searchAtk, searchDef)
        return response.map { it.toDomain() }
    }

    suspend fun searchCardsWithTAMTAtkDL (searchQuery: String, searchType: String, searchAttr: String, monsType: String, searchAtk: Int, searchDef: Int, searchLvl: Int): List<Card>{
        val response = cardDao.searchCardsWithTAMTAtkDL(searchQuery, searchType, searchAttr, monsType, searchAtk, searchDef, searchLvl)
        return response.map { it.toDomain() }
    }
}