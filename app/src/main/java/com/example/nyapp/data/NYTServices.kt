package com.example.nyapp.data

import com.example.nyapp.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "qSZOCbuH3rLaox81WubbmNngMETi3adZ",
        @Query("list") list: String = "hardcover-fiction"
    ) : Call<BookBodyResponse>

}