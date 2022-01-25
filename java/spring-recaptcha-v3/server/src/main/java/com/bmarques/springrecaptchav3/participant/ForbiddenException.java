package com.bmarques.springrecaptchav3.participant;

public class ForbiddenException extends Exception {
    public ForbiddenException(String message) {
        super(message);
    }
}