package com.example.cardTrackerProject

import android.app.Application
import com.example.cardTrackerProject.data.database.entities.CompetitiveCollectionEntity
import com.example.cardTrackerProject.data.database.entities.ForSaleCollectionEntity
import com.example.cardTrackerProject.data.database.entities.MyCollectionEntity
import com.example.cardTrackerProject.data.model.CardAmountChange
import com.example.cardTrackerProject.data.model.CardChecked
import com.example.cardTrackerProject.data.model.CardToDelete
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CardTrackerProject : Application() {
    companion object {
        var collectionSelected = ""

        var cardsChecked: MutableList<CardChecked> = ArrayList()

        var cardListMyColl: List<MyCollectionEntity> = ArrayList()

        var cardListForSaleColl: List<ForSaleCollectionEntity> = ArrayList()

        var cardListCompColl: List<CompetitiveCollectionEntity> = ArrayList()

        var cardsAmountForChange: MutableList<CardAmountChange> = ArrayList()

        var cardsToDelete: MutableList<CardToDelete> = ArrayList()
    }

}