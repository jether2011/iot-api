package br.com.i3focus.application.resource.request

import br.com.i3focus.domain.vo.Sensor
import br.com.i3focus.domain.vo.SensorMeasure
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class SensorMeasureRequest(
    @field:NotNull
    @field:NotEmpty
    val sensor: Sensor,
    @field:Min(value = 0L)
    @field:Positive
    val measure: Double = 0.0
) {
    fun toSensorMeasure() = SensorMeasure(sensor, measure)
}
