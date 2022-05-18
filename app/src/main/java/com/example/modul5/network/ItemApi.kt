package com.example.modul5.network

import androidx.compose.runtime.sourceInformationMarkerEnd
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = ""
private const val API_KEY = ""

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ItemApiService {
    @GET("")
    suspend fun getList() : List<String>
}

object ItemApi{
   val retrofitService: ItemApiService by lazy {
     retrofit.create(ItemApiService::class.java)
   }
}