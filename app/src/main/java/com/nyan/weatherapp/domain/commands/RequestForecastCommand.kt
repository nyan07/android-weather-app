package com.nyan.weatherapp.domain.commands

import com.nyan.weatherapp.domain.datasource.ForecastProvider
import com.nyan.weatherapp.domain.model.ForecastList

class RequestForecastCommand(
        private val zipCode:Long,
        private val forecastProvider:ForecastProvider = ForecastProvider()
        ): Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList  = forecastProvider.requestByZipCode(zipCode, DAYS)
}