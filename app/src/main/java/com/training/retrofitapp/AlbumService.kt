package com.training.retrofitapp

import retrofit2.http.GET
import com.training.retrofitapp.Albums
import retrofit2.Response
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums() : Response<Albums>

    @GET("/albums")
    suspend fun getAlbumByUserID(@Query("userId") userID: Int) : Response<Albums>

}