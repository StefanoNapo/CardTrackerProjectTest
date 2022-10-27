package com.example.mvvmexample.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "card_price_table")
data class CardPriceEntity (

    @ColumnInfo(name = "cardmarketPrice")
    var cardmarketPrice: String? = null,

    @ColumnInfo(name = "tcgplayerPrice")
    var tcgplayerPrice: String? = null,

    @ColumnInfo(name = "ebayPrice")
    var ebayPrice: String? = null,

    @ColumnInfo(name = "amazonPrice")
    var amazonPrice: String? = null,

    @ColumnInfo(name = "coolstuffincPrice")
    var coolstuffincPrice: String? = null
    )