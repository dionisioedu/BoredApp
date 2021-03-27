package com.example.bored.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://www.boredapi.com/api/" //activity

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface BoredApiService {
    @GET("activity")
    fun getActivity() : Call<String>
}

object BoreApi {
    val retrofitService : BoredApiService by lazy {
        retrofit.create(BoredApiService::class.java)
    }
}