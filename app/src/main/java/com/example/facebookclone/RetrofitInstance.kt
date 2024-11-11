package com.example.facebookclone

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // object creates a singleton
    // lazy = only created when first accessed
    val api: ApiResponse by lazy {
        Retrofit.Builder()
            .baseUrl("https://covidnewsapi.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiResponse::class.java)
    }
}
