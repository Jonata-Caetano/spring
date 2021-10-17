package com.bmarques.cardinsurancecharge.cardinsurance;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class CardInsuranceHandler extends SpringBootRequestHandler<SQSEvent, SQSEvent> {
}
