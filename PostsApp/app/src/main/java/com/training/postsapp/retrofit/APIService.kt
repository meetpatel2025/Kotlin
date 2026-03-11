package com.training.postsapp.retrofit

import com.training.postsapp.model.Post
import retrofit2.http.GET

interface APIService {

    @GET("/posts")
    suspend fun getPosts(): List<Post>

}