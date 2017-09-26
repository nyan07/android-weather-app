package com.nyan.weatherapp.domain.datasource

import com.nyan.weatherapp.data.db.ForecastDb
import com.nyan.weatherapp.data.server.ForecastServer
import com.nyan.weatherapp.domain.model.ForecastList
import com.nyan.weatherapp.extensions.firstResult

class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode:Long, days:Int): ForecastList = sources.firstResult {
        requestSources(it, days, zipCode)
    }

    fun requestSources(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}