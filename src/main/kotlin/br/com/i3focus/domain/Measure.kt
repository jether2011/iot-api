package br.com.i3focus.domain

import br.com.i3focus.domain.vo.Device
import br.com.i3focus.domain.vo.SensorMeasure
import io.azam.ulidj.ULID
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.Date

@Document("measure")
data class Measure(
    @Id
    val id: String = ULID.random(),
    @Indexed
    @Field("device")
    val device: Device,
    @Field("measures")
    val measures: List<SensorMeasure>,
    @Field("created_at")
    val createdAt: Date
)
