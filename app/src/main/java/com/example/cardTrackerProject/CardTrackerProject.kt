package com.example.cardTrackerProject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CardTrackerProject : Application(){
    companion object {
        var collectionSelected = ""

    }
}