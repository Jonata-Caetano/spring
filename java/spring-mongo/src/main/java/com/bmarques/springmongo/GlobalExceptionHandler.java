package com.bmarques.springmongo;

import com.bmarques.springmongo.invoice.InvoiceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvoiceNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, new Error(HttpStatus.NOT_FOUND, ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
