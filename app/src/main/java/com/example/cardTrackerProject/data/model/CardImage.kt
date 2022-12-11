package com.example.cardTrackerProject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CardImage(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("image_url")
    @Expose
    var imageUrl: String,

    @SerializedName("image_url_small")
    @Expose
    var imageUrlSmall: String? = null
)
