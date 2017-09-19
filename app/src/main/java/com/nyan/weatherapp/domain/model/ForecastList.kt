package com.nyan.weatherapp.domain.model

data class ForecastList(val city:String, val country:String, private val dailyForecast:List<Forecast>){
    val size:Int
        get() = dailyForecast.size

    operator fun get(position:Int):Forecast = dailyForecast[position]
}