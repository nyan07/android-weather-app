package com.nyan.weatherapp.domain.model

data class ForecastList(val city:String, val country:String, val dailyForecast:List<Forecast>)