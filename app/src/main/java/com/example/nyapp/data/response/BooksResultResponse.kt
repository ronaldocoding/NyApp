package com.example.nyapp.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BooksResultResponse(
    @Json(name = "book_details")
    val bookDetailsResponse: List<BookDetailsResponse>
)