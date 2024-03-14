package com.betrybe.trybeclima.data.model

import com.google.gson.annotations.SerializedName

data class WindData (
    val speed: Double,
    @SerializedName("deg")
    val degrees: Int,
    val gust: Double
)
