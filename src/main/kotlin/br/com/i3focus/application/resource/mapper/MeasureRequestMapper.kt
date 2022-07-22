package br.com.i3focus.application.resource.mapper

import br.com.i3focus.application.resource.request.MeasureRequest
import br.com.i3focus.domain.Mapper
import br.com.i3focus.domain.Measure
import org.springframework.stereotype.Component

@Component
class MeasureRequestMapper : Mapper<MeasureRequest, Measure> {
    override fun map(input: MeasureRequest): Measure =
        Measure(
            device = input.device.toDevice(),
            measures = input.measures.map { it.toSensorMeasure() },
            createdAt = input.createdAt.toDate()
        )
}
