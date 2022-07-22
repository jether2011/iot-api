package br.com.i3focus.application.resource.response

import br.com.i3focus.domain.vo.Device
import br.com.i3focus.domain.vo.SensorMeasure
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING
import org.joda.time.DateTime

data class MeasureResponse(
    val id: String,
    val device: Device,
    val measures: List<SensorMeasure>,
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    val createdAt: DateTime
)
