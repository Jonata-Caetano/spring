package com.bmarques.sqsproducer.domain.cardinsurance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CardInsuranceService {

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    private final QueueMessagingTemplate queueMessagingTemplate;

    public CardInsuranceService(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public void save(CardInsuranceChargedEntity cardInsuranceChargedEntity) {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(cardInsuranceChargedEntity).build());
    }
}
