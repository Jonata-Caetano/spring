package com.bmarques.cardinsurancecharge;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.bmarques.cardinsurancecharge.cardinsurance.CardInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class CardInsuranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardInsuranceApplication.class, args);
    }

    @Autowired
    private CardInsuranceService service;

    @Bean
    public Function<SQSEvent, String> getCards() {
        return value -> service.getCardsInsurance(value);
    }

}
