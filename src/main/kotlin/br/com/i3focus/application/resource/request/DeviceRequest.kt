package br.com.i3focus.application.resource.request

import br.com.i3focus.domain.vo.Device
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class DeviceRequest(
    @field:NotNull
    @field:NotEmpty
    val deviceId: String,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
) {
    fun toDevice() = Device(deviceId.uppercase(), latitude, longitude)
}
