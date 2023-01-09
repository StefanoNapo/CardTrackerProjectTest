package com.example.cardTrackerProject.ui

import com.example.cardTrackerProject.data.model.CardChecked

interface CardsCheckedListener {

    fun getCardChecked(cardsChecked: MutableList<CardChecked> = ArrayList())

}