package br.com.i3focus.application.resource.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING
import org.joda.time.DateTime

data class MeasureRequest(
    val device: DeviceRequest,
    val measures: List<SensorMeasureRequest>,
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    val createdAt: DateTime
)
