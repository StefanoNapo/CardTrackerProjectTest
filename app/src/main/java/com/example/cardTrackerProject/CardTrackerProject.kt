package com.example.cardTrackerProject

import android.app.Application
import com.example.cardTrackerProject.data.model.CardChecked
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CardTrackerProject : Application(){
    companion object {
        var collectionSelected = ""

        var cardsChecked: MutableList<CardChecked> = ArrayList()

        var checkedCardsName: MutableList<String> = ArrayList()
    }

}