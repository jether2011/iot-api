package br.com.i3focus.domain

import io.azam.ulidj.ULID
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("measure")
data class Measure(
    @Id
    val id: String = ULID.random(),
    @Indexed
    @Field("device_id")
    val deviceId: String,
    @Field("temperature")
    val temperature: Double = 0.0,
    @Field("air_humidity")
    val airHumidity: Double = 0.0
)
