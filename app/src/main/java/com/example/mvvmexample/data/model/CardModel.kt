package com.example.mvvmexample.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CardModel (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("type")
    @Expose
    var type: String? = null,

    @SerializedName("desc")
    @Expose
    var desc: String? = null,

    @SerializedName("atk")
    @Expose
    var atk: Int? = null,

    @SerializedName("race")
    @Expose
    var race: String? = null,

    @SerializedName("attribute")
    @Expose
    var attribute: String? = null,

    @SerializedName("archetype")
    @Expose
    var archetype: String? = null,

    @SerializedName("linkval")
    @Expose
    var linkval: Int? = null,

    @SerializedName("linkmarkers")
    @Expose
    var linkmarkers: List<String>? = null,

    @SerializedName("card_sets")
    @Expose
    var cardSets: List<CardSet>? = null,

    @SerializedName("card_images")
    @Expose
    var cardImages: List<CardImage>? = null,

    @SerializedName("card_prices")
    @Expose
    var cardPrices: List<CardPrice>? = null,

    @SerializedName("def")
    @Expose
    var def: Int? = null,

    @SerializedName("level")
    @Expose
    var level: Int? = null
)