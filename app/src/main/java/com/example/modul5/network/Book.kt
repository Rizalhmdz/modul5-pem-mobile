package com.example.modul5.network

data class Book (
    val title: String,
    val authors: List<String>,
    val publisher: String,
    val publishDate: String,
    val description: String,
    val pageCount: Int
    )