package com.bmarques.springamazonlambda;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UpperCaseStringHandler implements Function<String, String> {

    @Override
    public String apply(String input) {
        return input.toUpperCase();
    }
}
