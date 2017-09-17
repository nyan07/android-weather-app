package com.nyan.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

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

        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
    }
}
