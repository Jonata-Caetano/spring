package com.bmarques.cardinsurancecharge;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.bmarques.cardinsurancecharge.cardinsurance.CardInsuranceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@Slf4j
@SpringBootApplication
public class CardInsuranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardInsuranceApplication.class, args);
    }

    @Autowired
    private CardInsuranceService service;

    @Bean
    public Function<SQSEvent, SQSEvent> getCards() {
        return value -> service.getCardsInsurance(value);
    }

}
