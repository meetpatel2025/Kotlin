package com.training.retrofitapp

import com.google.gson.annotations.SerializedName


data class Company(
    @SerializedName("id")
    val ID: Int,
    val countryCode: String,
    @SerializedName("market_cap")
    val marketCap: Double,
    val name: String
)
