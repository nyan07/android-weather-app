package com.nyan.weatherapp.domain.datasource

import com.nyan.weatherapp.data.db.ForecastDb
import com.nyan.weatherapp.data.server.ForecastServer
import com.nyan.weatherapp.domain.model.Forecast
import com.nyan.weatherapp.domain.model.ForecastList
import com.nyan.weatherapp.extensions.firstResult

class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode:Long, days:Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id:Long):Forecast = requestToSources {
        it.requestDayForecast(id)
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(f:(ForecastDataSource) -> T?) : T =
                sources.firstResult { f(it) }
}