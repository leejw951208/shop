package com.example.shop.global.exception

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(this.javaClass)!!

    @ExceptionHandler
    fun handleResponseStatusException(ex: ResponseStatusException, request: HttpServletRequest): ResponseEntity<Any> {
        val exceptionDto = ResponseStatusExceptionDto(
            error = HttpStatus.valueOf(ex.statusCode.value()).name,
            path = request.requestURL.toString(),
            message = ex.reason.toString(),
            status = ex.statusCode.value(),
            timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        )
        log.error(ex.reason)
        return ResponseEntity.status(ex.statusCode).body(exceptionDto)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<Any> {
        val exceptionDto = ResponseStatusExceptionDto(
            error = HttpStatus.valueOf(ex.statusCode.value()).name,
            path = request.requestURL.toString(),
            message = ex.bindingResult.fieldError?.defaultMessage ?: "not found error",
            status = ex.statusCode.value(),
            timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        )
        log.error(ex.message)
        return ResponseEntity.status(ex.statusCode).body(exceptionDto)
    }
}