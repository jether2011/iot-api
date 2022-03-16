package br.com.i3focus.repository

import br.com.i3focus.domain.Measure
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface MeasureRepository : ReactiveMongoRepository<Measure, String> {
    fun findByDeviceId(deviceId: String): Flux<Measure>
}
