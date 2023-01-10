package com.example.cardTrackerProject.domain.model

import com.example.cardTrackerProject.data.database.entities.*
import com.example.cardTrackerProject.data.model.CardImage
import com.example.cardTrackerProject.data.model.CardModel
import com.example.cardTrackerProject.data.model.CardPrice
import com.example.cardTrackerProject.data.model.CardSet


data class Card (
    var id: Int? = null,


    var name: String? = null,


    var type: String? = null,


    var desc: String? = null,


    var atk: Int? = null,


    var race: String? = null,


    var attribute: String? = null,


    var archetype: String? = null,


    var linkval: Int? = null,


    var linkmarkers: List<String>? = null,


    var cardSets: List<CardSet>? = null,


    var cardImages: List<CardImage>? = null,


    var cardPrices: List<CardPrice>? = null,


    var def: Int? = null,


    var level: Int? = null
)

fun CardModel.toDomain() = Card(id, name, type, desc, atk, race, attribute, archetype, linkval, linkmarkers, cardSets, cardImages, cardPrices, def, level)

fun CardEntity.toDomain() = Card(id, name, type, desc, atk, race, attribute, archetype, linkval, linkmarkers, cardSets, cardImages, cardPrices, def, level)
