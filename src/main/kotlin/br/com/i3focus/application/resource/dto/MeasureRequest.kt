package br.com.i3focus.application.resource.dto

import br.com.i3focus.domain.Measure
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class MeasureRequest(
    @field:NotNull
    @field:NotEmpty
    val deviceId: String,
    @field:Min(value = 0L)
    @field:Positive
    val temperature: Double,
    @field:Min(value = 0L)
    @field:Positive
    val airHumidity: Double
) {
    fun toMeasure() = Measure(
        deviceId = deviceId,
        temperature = temperature,
        airHumidity = airHumidity
    )
}
