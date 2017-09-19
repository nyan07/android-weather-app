package com.nyan.weatherapp.domain.commands

import com.nyan.weatherapp.data.ForecastRequest
import com.nyan.weatherapp.domain.mappers.ForecastDataMapper
import com.nyan.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode:String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}