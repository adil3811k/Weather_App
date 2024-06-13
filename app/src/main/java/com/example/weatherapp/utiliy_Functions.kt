package com.example.weatherapp

import com.example.weatherapp.Model.cardModel
import com.example.weatherapp.Model.weatherModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone
import kotlin.math.pow
import kotlin.math.roundToInt

object utiliy_Functions {
    fun UnixTimetoNormalDataTime(UnixTime:Long):String{
        val date = Date(UnixTime*1000L)
        val format  = SimpleDateFormat("hh:mm:ss aa")
        format.timeZone = TimeZone.getDefault()
        return format.format(date)
    }
    fun KalvinToCenlius(kelvin:Double):String{
        val celcius  = kelvin-273.15

        return String.format("%.1f",celcius)+"\u2103"
    }
//    \u2103
    fun getListbywetherModel(weatherModel: weatherModel):List<cardModel>{
        val list :MutableList<cardModel> = mutableListOf()
    list.add(cardModel(R.drawable.humidity,"Humidity",weatherModel.main.humidity.toString()+"hPa"))
    list.add(cardModel(R.drawable.wind,"Wind Speed",weatherModel.wind.speed.toString()+"m/s"))
    list.add(cardModel(R.drawable.sea_waves,"see level",weatherModel.main.sea_level.toString()+"MSAL"))
    list.add(cardModel(R.drawable.visibility,"Visibility",weatherModel.visibility.toString()+"m"))
    list.add(cardModel(R.drawable.sunset,"Sun Set",utiliy_Functions.UnixTimetoNormalDataTime(weatherModel.sys.sunset.toLong())))
    list.add(cardModel(R.drawable.sunrise,"Sun Rise",utiliy_Functions.UnixTimetoNormalDataTime(weatherModel.sys.sunrise.toLong())))
    list.add(cardModel(R.drawable.pressure,"Pressure",weatherModel.main.pressure.toString()+"mb"))
    list.add(cardModel(R.drawable.cloud,"Cloud",weatherModel.clouds.all.toString()+"%"))
    list.add(cardModel(R.drawable.coordinate,"Coordinates","Longitude:  ${weatherModel.coord.lon} \n Latitude : ${weatherModel.coord.lat}"))
        return list
    }
}
