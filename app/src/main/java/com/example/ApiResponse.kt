package com.example

import retrofit2.Call
import retrofit2.http.GET

interface ApiResponse {
    @GET("posts")
    fun getPosts(): Call<PostWrapper>
    //
}
