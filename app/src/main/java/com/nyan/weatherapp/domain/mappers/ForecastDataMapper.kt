package com.nyan.weatherapp.domain.mappers

import java.util.concurrent.TimeUnit
import com.nyan.weatherapp.data.server.Forecast
import com.nyan.weatherapp.data.server.ForecastResult
import com.nyan.weatherapp.domain.model.ForecastList
import java.util.*
import com.nyan.weatherapp.domain.model.Forecast as ModelForecast

class ForecastDataMapper {
    fun convertFromDataModel(zipCode:Long, forecast: ForecastResult): ForecastList =
            ForecastList(zipCode, forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode:String) = "http://openweathermap.org/img/w/$iconCode.png"
}