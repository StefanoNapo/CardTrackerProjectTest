package com.example.mvvmexample

import com.example.mvvmexample.data.model.CardModel
import com.google.gson.Gson
import java.io.FileReader


class Parser {

    var gson = Gson()
    var cardModel: CardModel = gson.fromJson(FileReader("cards.json"), CardModel::class.java)

}