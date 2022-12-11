package com.example.cardTrackerProject.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CardPrice(
    @SerializedName("cardmarket_price")
    @Expose
    var cardmarketPrice: String? = null,

    @SerializedName("tcgplayer_price")
    @Expose
    var tcgplayerPrice: String? = null,

    @SerializedName("ebay_price")
    @Expose
    var ebayPrice: String? = null,

    @SerializedName("amazon_price")
    @Expose
    var amazonPrice: String? = null,

    @SerializedName("coolstuffinc_price")
    @Expose
    var coolstuffincPrice: String? = null
)