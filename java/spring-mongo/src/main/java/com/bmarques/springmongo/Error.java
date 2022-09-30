package com.bmarques.springmongo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class Error {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String message;

    public Error(HttpStatus status, String message) {
        this.status = status;
        timestamp = LocalDateTime.now();
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "status=" + status +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
