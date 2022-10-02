package com.bmarques.springmongo

import com.bmarques.springmongo.invoice.InvoiceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler  {

    @ExceptionHandler
    fun handleIllegalStateException(ex: InvoiceNotFoundException): ResponseEntity<ErrorMessageModel> {
        return ResponseEntity(ErrorMessageModel(HttpStatus.NOT_FOUND.value(), ex.message), HttpStatus.NOT_FOUND)
    }
}
