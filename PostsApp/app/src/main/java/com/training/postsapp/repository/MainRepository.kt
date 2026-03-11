package com.training.postsapp.repository

import com.training.postsapp.retrofit.APIService
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: APIService) {
    suspend fun getPosts() = apiService.getPosts()

}