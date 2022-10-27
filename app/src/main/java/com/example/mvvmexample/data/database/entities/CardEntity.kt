package com.example.mvvmexample.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmexample.data.model.CardImage
import com.example.mvvmexample.data.model.CardPrice
import com.example.mvvmexample.data.model.CardSet

@Entity(tableName = "card_table")
data class CardEntity (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "type")
    var type: String? = null,

    @ColumnInfo(name = "desc")
    var desc: String? = null,

    @ColumnInfo(name = "atk")
    var atk: Int? = null,

    @ColumnInfo(name = "race")
    var race: String? = null,

    @ColumnInfo(name = "attribute")
    var attribute: String? = null,

    @ColumnInfo(name = "archetype")
    var archetype: String? = null,

    @ColumnInfo(name = "linkval")
    var linkval: Int? = null,

    @ColumnInfo(name = "linkmarkers")
    var linkmarkers: List<String>? = null,

    @ColumnInfo(name = "cardSets")
    var cardSets: List<CardSet>? = null,

    @ColumnInfo(name = "cardImages")
    var cardImages: List<CardImage>? = null,

    @ColumnInfo(name = "cardPrices")
    var cardPrices: List<CardPrice>? = null,

    @ColumnInfo(name = "def")
    var def: Int? = null,

    @ColumnInfo(name = "level")
    var level: Int? = null
    )