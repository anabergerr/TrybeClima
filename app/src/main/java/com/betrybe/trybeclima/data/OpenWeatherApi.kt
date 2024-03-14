package com.betrybe.trybeclima.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OpenWeatherApi {

    private var retrofit: Retrofit? = null

    fun getInstance(): OpenWeatherApiService {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit?.create(OpenWeatherApiService::class.java)!!
    }

}