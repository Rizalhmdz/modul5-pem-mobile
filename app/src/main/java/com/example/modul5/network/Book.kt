package com.example.modul5.network

import com.squareup.moshi.Json

data class ResponseData(
    val kind: String = "",
    val totalItems: Int = 0,
    val items: List<Items>
)

data class Items(
    @Json(name = "volumeInfo")
    val bookItems: BookItem
)

data class BookItem(
    @Json(name = "imageLinks")
    val cover: ImageLinks,
    val title: String = "",
    val authors: List<String>,
    val publisher: String = "",
    val publishedDate: String = "",
    val description: String = ""
)

data class ImageLinks(
    val thumbnail: String
)