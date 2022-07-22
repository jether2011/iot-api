package br.com.i3focus.application.resource

import br.com.i3focus.application.resource.mapper.MeasureRequestMapper
import br.com.i3focus.application.resource.mapper.MeasureResponseMapper
import br.com.i3focus.application.resource.request.MeasureRequest
import br.com.i3focus.application.resource.response.MeasureResponse
import br.com.i3focus.repository.MeasureRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.DESC
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/measures")
class MeasureController(
    private val measureRequestMapper: MeasureRequestMapper,
    private val measureResponseMapper: MeasureResponseMapper,
    private val measureRepository: MeasureRepository
) {
    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createMeasure(@RequestBody @Validated request: MeasureRequest): Mono<MeasureResponse> =
        request.let {
            measureRepository.save(measureRequestMapper.map(it))
        }.let {
            it.map { measure -> measureResponseMapper.map(measure) }
        }

    /**
     * @return reactor.core.publisher.Flux<MeasureResponse>
     */
    @CrossOrigin
    @GetMapping
    fun findAll(): Flux<MeasureResponse> =
        PageRequest.of(
            0,
            500,
            Sort.by(DESC, "createdAt")
        ).let { pageable ->
            measureRepository.findAll(pageable.sort).map { measureResponseMapper.map(it) }
        }

    /**
     * @param deviceId - the device id to retrieve all measure for it
     * @return reactor.core.publisher.Flux<MeasureResponse>
     */
    @CrossOrigin
    @GetMapping("/{deviceId}/device")
    fun findByDeviceId(
        @PathVariable("deviceId") deviceId: String,
    ): Flux<MeasureResponse> = deviceId.uppercase().let { device ->
        measureRepository.findByDeviceDeviceId(device).map { measureResponseMapper.map(it) }
    }
}
