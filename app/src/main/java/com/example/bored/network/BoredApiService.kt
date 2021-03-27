package com.example.bored.network

import com.example.bored.data.ActivityModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://www.boredapi.com/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BoredApiService {
    @GET("activity")
    fun getActivity() : Call<ActivityModel>
}

object BoreApi {
    val retrofitService : BoredApiService by lazy {
        retrofit.create(BoredApiService::class.java)
    }
}