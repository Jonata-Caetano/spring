package com.bmarques.cardinsurancecharge.cardinsurance;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CardInsuranceService {

    @Autowired
    private ObjectMapper objectMapper;

    public String getCardsInsurance(SQSEvent event) {

        for (SQSMessage msg : event.getRecords()) {
            CardInsuranceChargedEntity cardInsuranceCharged = new CardInsuranceChargedEntity();

            try {
                cardInsuranceCharged = objectMapper
                        .readValue(msg.getBody(), CardInsuranceChargedEntity.class);

                log.info(cardInsuranceCharged.toString());

                throw new RuntimeException("Occurred a error!");

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            log.info("To String!");
            log.info(cardInsuranceCharged.toString());
        }

        return "Lambda executed with success!";
    }
}
