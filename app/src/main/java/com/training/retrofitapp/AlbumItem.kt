package com.training.retrofitapp
import com.google.gson.annotations.SerializedName;


data class AlbumItem(
    @SerializedName("userID")
    val userID:Int,
    @SerializedName("id")
    val id : Int,
    @SerializedName("title")
    val title : String)
