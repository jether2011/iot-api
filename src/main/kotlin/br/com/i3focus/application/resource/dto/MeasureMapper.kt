package br.com.i3focus.application.resource.dto

import br.com.i3focus.domain.Mapper
import br.com.i3focus.domain.Measure
import org.springframework.stereotype.Component

@Component
class MeasureMapper : Mapper<MeasureResponse, Measure> {
    override fun toEntity(input: MeasureResponse): Measure =
        Measure(
            deviceId = input.deviceId,
            temperature = input.temperature,
            airHumidity = input.airHumidity
        )

    override fun toDto(input: Measure): MeasureResponse =
        MeasureResponse(
            deviceId = input.deviceId,
            temperature = input.temperature,
            airHumidity = input.airHumidity
        )
}
