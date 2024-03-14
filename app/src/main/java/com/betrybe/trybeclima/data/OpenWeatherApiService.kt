package com.betrybe.trybeclima.data

import com.betrybe.trybeclima.data.model.CurrentWeatherData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApiService {

    @GET("weather")
    suspend fun getCurrentWeatherData(
        @Query("q") city:String,
        @Query("appid") appId: String,
        @Query("units") units: String = "metric"): Response<CurrentWeatherData>

}