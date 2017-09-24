package com.nyan.weatherapp.data.server

data class Weather(
        val id:Long,
        val main:String,
        val description:String,
        val icon:String
)