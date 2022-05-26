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
    @Json(name = "imageLink")
    val cover: String? = "https://cdn.shopify.com/s/files/1/1338/0845/products/foundations-lineup_800x1200.jpg?v=1528927785",
    @Json(name = "name")
    val title: String? = "",
    @Json(name = "tag_list")
    val authors: List<String>?,
    @Json(name = "product_link")
    val publisher: String? = "",
    @Json(name = "updated_at")
    val publishedDate: String? = "",
    val description: String? = ""
)

data class ImageLinks(
    val thumbnail: String
)