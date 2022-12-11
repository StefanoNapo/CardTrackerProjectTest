package com.example.cardTrackerProject.ui

interface DialogCommunicator {
    fun getCardTypeSelected(cardTypeSelec: String)

    fun getMonsterTypeSelected(monsTypeSelec: String)

    fun getAttrSelected(attrSelec: String)

    fun getAtkSelected(atkSelec: Int?)

    fun getDefSelected(defSelec: Int?)

    fun getLvlSelected(lvlSelec: Int?)

}