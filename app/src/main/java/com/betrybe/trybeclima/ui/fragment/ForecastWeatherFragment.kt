package com.betrybe.trybeclima.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybeclima.ui.adapter.ForecastData
import com.betrybe.trybeclima.ui.adapter.ForecastDataAdapter
import com.betrybe.trybeclima.R

class ForecastWeatherFragment: Fragment() {

    private lateinit var mForecastWeatherList: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_forecast_weather, container, false)
        mForecastWeatherList = view.findViewById(R.id.forecast_weather_list)

        val forecastList = listOf(
            ForecastData(32.0, 29.0, "15/02"),
            ForecastData(32.0, 29.0, "15/02"),
            ForecastData(32.0, 29.0, "15/02"),
            ForecastData(32.0, 29.0, "15/02"),
            ForecastData(32.0, 29.0, "15/02"),
            ForecastData(32.0, 29.0, "15/02"),
            ForecastData(32.0, 29.0, "15/02"),
            ForecastData(32.0, 29.0, "15/02"),
            ForecastData(32.0, 29.0, "15/02"),
        )

        mForecastWeatherList.layoutManager = GridLayoutManager(context, 3)
        mForecastWeatherList.adapter = ForecastDataAdapter(forecastList)
        mForecastWeatherList.hasFixedSize()

        return view

    }

}