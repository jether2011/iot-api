package br.com.i3focus.repository

import br.com.i3focus.domain.Measure
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface MeasureRepository : ReactiveSortingRepository<Measure, String> {
    fun findByDeviceDeviceId(deviceId: String): Flux<Measure>
}
