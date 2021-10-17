package com.bmarques.cardinsurancecharge.cardinsurance;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Slf4j
@Service
public class CardInsuranceService {

    @Autowired
    private ObjectMapper objectMapper;

    public SQSEvent getCardsInsurance(SQSEvent event) {

        for (SQSMessage msg : event.getRecords()) {


            CardInsuranceChargedEntity cardInsuranceCharged = new CardInsuranceChargedEntity();


            try {
                cardInsuranceCharged = objectMapper
                        .readValue(msg.getBody(), CardInsuranceChargedEntity.class);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            log.info("To String!");
            log.info(msg.getAttributes().toString());
            log.info(cardInsuranceCharged.toString());

        }

        SQSEvent sqsEvent = new SQSEvent();
        sqsEvent.setRecords(event.getRecords());
        return sqsEvent;
    }
}
