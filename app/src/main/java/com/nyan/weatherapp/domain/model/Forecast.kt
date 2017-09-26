package com.nyan.weatherapp.domain.model

data class Forecast(val id:Long, val date:Long, val description:String, val high:Int,
                    val low:Int, val iconUrl:String)