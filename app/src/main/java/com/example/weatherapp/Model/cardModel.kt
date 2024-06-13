package com.example.weatherapp.Model

import androidx.annotation.DrawableRes

data class cardModel(
    @DrawableRes val icon:Int,
    val tital:String,
    val data:String
)
