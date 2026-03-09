package com.training.retrofitapp

import retrofit2.Response
import retrofit2.http.GET

interface CompaniesService {

    @GET("/companies")
    suspend fun getCompanies() : Response<CompaniesList>
}