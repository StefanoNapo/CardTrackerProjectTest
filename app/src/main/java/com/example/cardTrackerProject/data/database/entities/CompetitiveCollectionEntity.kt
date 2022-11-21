package com.example.cardTrackerProject.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.cardTrackerProject.data.database.Converters
import com.example.cardTrackerProject.data.database.ImageConverter
import com.example.cardTrackerProject.data.database.PriceConverter
import com.example.cardTrackerProject.data.database.SetConverter
import com.example.cardTrackerProject.data.model.CardImage
import com.example.cardTrackerProject.data.model.CardPrice
import com.example.cardTrackerProject.data.model.CardSet

@Entity(tableName = "competitive_collection")
data class CompetitiveCollectionEntity (


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
    @field:TypeConverters(Converters::class)
    var linkmarkers: List<String>? = null,

    @ColumnInfo(name = "cardSets")
    @field:TypeConverters(SetConverter::class)
    var cardSets: List<CardSet>? = null,

    @ColumnInfo(name = "card_images")
    @field:TypeConverters(ImageConverter::class)
    var cardImages: List<CardImage>? = null,

    @ColumnInfo(name = "cardPrices")
    @field:TypeConverters(PriceConverter::class)
    var cardPrices: List<CardPrice>? = null,

    @ColumnInfo(name = "def")
    var def: Int? = null,

    @ColumnInfo(name = "level")
    var level: Int? = null,

    @ColumnInfo(name = "quantity")
    var quantity: Int? = null
)

