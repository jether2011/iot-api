package br.com.i3focus.application.resource

import br.com.i3focus.application.resource.dto.MeasureMapper
import br.com.i3focus.application.resource.dto.MeasureRequest
import br.com.i3focus.application.resource.dto.MeasureResponse
import br.com.i3focus.repository.MeasureRepository
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/measures")
class MeasureController(
    private val mapper: MeasureMapper,
    private val measureRepository: MeasureRepository
) {
    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createMeasure(@RequestBody @Validated request: MeasureRequest): Mono<MeasureResponse> =
        request.toMeasure().let {
            measureRepository.save(it)
        }.let {
            it.map { measure -> mapper.toDto(measure) }
        }

    /**
     * @return reactor.core.publisher.Flux<MeasureResponse>
     */
    @CrossOrigin
    @GetMapping
    fun findAll(): Flux<MeasureResponse> =
        measureRepository.findAll().map { mapper.toDto(it) }

    /**
     * @param deviceId - the device id to retrieve all measure for it
     * @return reactor.core.publisher.Flux<MeasureResponse>
     */
    @CrossOrigin
    @GetMapping("/{deviceId}/device")
    fun findByDeviceId(
        @PathVariable("deviceId") deviceId: String,
    ): Flux<MeasureResponse> = deviceId.lowercase().let { device ->
        measureRepository.findByDeviceId(device).map { mapper.toDto(it) }
    }
}
