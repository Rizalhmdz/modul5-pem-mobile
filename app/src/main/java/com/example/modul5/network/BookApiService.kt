package com.example.modul5.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://www.googleapis.com/books/v1/"
private const val API_KEY = "AIzaSyCEaxYLA7X0ESATY2wLAfu7AdLLp7Dsp7o"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface BookApiService {
    @GET("volumes?q=Mythology&key=$API_KEY")
    suspend fun getListBook(): ResponseData
}

object BookApi {
    val retrofitService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
}