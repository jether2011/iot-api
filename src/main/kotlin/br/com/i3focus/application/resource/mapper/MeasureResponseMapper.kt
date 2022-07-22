package br.com.i3focus.application.resource.mapper

import br.com.i3focus.application.resource.response.MeasureResponse
import br.com.i3focus.domain.Mapper
import br.com.i3focus.domain.Measure
import org.joda.time.DateTime
import org.springframework.stereotype.Component

@Component
class MeasureResponseMapper : Mapper<Measure, MeasureResponse> {
    override fun map(input: Measure): MeasureResponse =
        MeasureResponse(
            id = input.id,
            device = input.device,
            measures = input.measures,
            createdAt = DateTime(input.createdAt)
        )
}
