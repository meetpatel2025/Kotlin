package com.training.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.training.quotesapp.model.Quote

object DataManager {
    var data= emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("Quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }
}