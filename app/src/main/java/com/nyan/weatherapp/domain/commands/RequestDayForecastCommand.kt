package com.nyan.weatherapp.domain.commands

import com.nyan.weatherapp.domain.datasource.ForecastProvider
import com.nyan.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
        val id:Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)

}