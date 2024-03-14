package com.betrybe.trybeclima.data.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherData (
    @SerializedName("coord")
    val coordinate: CoordinateData,
    val weather: List<WeatherData>,
    val base: String,
    val main: MainData,
    val visibility: Int,
    val wind: WindData,
    val rain:RainData,
    val clouds: CloudData,
    @SerializedName("dt")
    val datetime: Long,
    val sys: SysData,
    val timezone: Int,
    val id: Int,
    val name:String,
    @SerializedName("cod")
    val code: Int
)
