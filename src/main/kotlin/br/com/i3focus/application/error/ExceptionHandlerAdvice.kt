package br.com.i3focus.application.error

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.beans.TypeMismatchException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.support.WebExchangeBindException
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionHandlerAdvice {
    companion object{
        const val BAD_REQUEST = "BAD_REQUEST"
        const val INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR"
    }

    @ExceptionHandler(value = [
        ConstraintViolationException::class
    ])
    fun handleConstraintViolationException(e: ConstraintViolationException): ResponseEntity<ErrorResponse> =
        ResponseEntity<ErrorResponse>(
            ErrorResponse(
                BAD_REQUEST,
                e.message,
                e.cause?.message,
                HttpStatus.BAD_REQUEST.value()
            ),
            HttpStatus.BAD_REQUEST
        )

    @ExceptionHandler(value = [
        Exception::class
    ])
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> =
        ResponseEntity<ErrorResponse>(
            ErrorResponse(
                INTERNAL_SERVER_ERROR,
                e.message,
                e.cause?.message,
                HttpStatus.INTERNAL_SERVER_ERROR.value()
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )

    @ExceptionHandler(value = [
        RuntimeException::class
    ])
    fun handleGenericException(e: RuntimeException): ResponseEntity<ErrorResponse> =
        ResponseEntity<ErrorResponse>(
            ErrorResponse(
                INTERNAL_SERVER_ERROR,
                e.message,
                e.cause?.message,
                HttpStatus.INTERNAL_SERVER_ERROR.value()
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )

    @ExceptionHandler(TypeMismatchException::class)
    fun handleTypeMismatchException(e: TypeMismatchException): HttpStatus {
        throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value '${e.value}'", e)
    }

    @ExceptionHandler(WebExchangeBindException::class)
    fun handleWebExchangeBindException(e: WebExchangeBindException): HttpStatus {
        throw object : WebExchangeBindException(e.methodParameter!!, e.bindingResult) {
            override val message = "${fieldError?.field} has invalid value '${fieldError?.rejectedValue}'"
        }
    }
}

data class ErrorResponse(
    val error: String,
    val message: String?,
    val cause: String?,
    val status: Int,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    val timestamp: LocalDateTime = LocalDateTime.now()
)