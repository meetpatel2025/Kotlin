package com.training.androidfundametalsapp

import android.content.Context
import com.google.gson.Gson
import com.training.androidfundametalsapp.model.Topics

object TopicsController {
    var topicsList : Array<Topics> = emptyArray<Topics>()
    fun loadAssetsFromJSON(context: Context){
        val inputStream = context.assets.open("Topics.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        topicsList =gson.fromJson(json, Array<Topics>::class.java)
    }
}