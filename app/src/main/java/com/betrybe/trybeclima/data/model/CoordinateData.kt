package com.betrybe.trybeclima.data.model

import com.google.gson.annotations.SerializedName

data class CoordinateData (
    @SerializedName("lon")
    val longitude:Double,
    @SerializedName("lat")
    val latitude: Double
)
