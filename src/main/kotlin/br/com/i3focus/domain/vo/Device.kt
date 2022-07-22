package br.com.i3focus.domain.vo

data class Device(
    val deviceId: String,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)
