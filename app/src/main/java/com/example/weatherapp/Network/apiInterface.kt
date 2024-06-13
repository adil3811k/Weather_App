package com.example.weatherapp.Network

import com.example.weatherapp.Model.weatherModel
import retrofit2.http.GET
import retrofit2.http.Query

//Base url https://api.openweathermap.org/data/2.5/weather?q=Bhiwandi&appid=d60c49c9df94ec6787f8682aa4eb6fe5



interface apiInterface {
    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("q")city:String = "Bhiwandi",
        @Query("appid")id:String = "d60c49c9df94ec6787f8682aa4eb6fe5"
    ):weatherModel
}