package com.example.cardTrackerProject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CardSet(
    @SerializedName("set_name")
    @Expose
    var setName: String? = null,

    @SerializedName("set_code")
    @Expose
    var setCode: String? = null,

    @SerializedName("set_rarity")
    @Expose
    var setRarity: String? = null,

    @SerializedName("set_rarity_code")
    @Expose
    var setRarityCode: String? = null,

    @SerializedName("set_price")
    @Expose
    var setPrice: String? = null
)