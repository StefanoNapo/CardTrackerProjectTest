package com.example.mvvmexample.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "card_set_table")
data class CardSetEntity (

    @ColumnInfo(name = "setName")
    var setName: String? = null,

    @ColumnInfo(name = "setCode")
    var setCode: String? = null,

    @ColumnInfo(name = "setRarity")
    var setRarity: String? = null,

    @ColumnInfo(name = "setRarityCode")
    var setRarityCode: String? = null,

    @ColumnInfo(name = "setPrice")
    var setPrice: String? = null
    )