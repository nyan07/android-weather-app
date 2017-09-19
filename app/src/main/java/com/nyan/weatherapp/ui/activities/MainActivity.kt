package com.nyan.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.nyan.weatherapp.ui.adapters.ForecastListAdapter
import com.nyan.weatherapp.R
import com.nyan.weatherapp.data.Request
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Mon 6/23 - Sunny - 31/17",
        "Mon 6/23 - Sunny - 31/17",
        "Mon 6/23 - Sunny - 31/17",
        "Mon 6/23 - Sunny - 31/17",
        "Mon 6/23 - Sunny - 31/17",
        "Mon 6/23 - Sunny - 31/17"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"

        doAsync {
            Request(url).run()
            uiThread {
                longToast("Request performed")
            }
        }
    }
}
