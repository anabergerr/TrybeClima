package com.betrybe.trybeclima.data.model

import java.io.FileDescriptor

data class WeatherData (
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
