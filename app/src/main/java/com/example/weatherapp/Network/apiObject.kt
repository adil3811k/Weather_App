package com.example.weatherapp.Network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val BACE_URL = "https://api.openweathermap.org"
object apiObject  {
    val apiService :apiInterface by lazy {
        val retrofit  = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BACE_URL)
            .build()
        retrofit.create(apiInterface::class.java)
    }
}