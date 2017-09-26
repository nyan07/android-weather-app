package com.nyan.weatherapp.domain.datasource

import com.nyan.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode:Long, date:Long): ForecastList?
}