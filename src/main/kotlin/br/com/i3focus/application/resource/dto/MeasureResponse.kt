package br.com.i3focus.application.resource.dto

data class MeasureResponse(
    val deviceId: String,
    val temperature: Double,
    val airHumidity: Double
)
