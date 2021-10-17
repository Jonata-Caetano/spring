package com.bmarques.springamazonsqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSController {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @GetMapping("/put/{msg}")
    public String putMessageToQueue(@PathVariable("msg") String message) {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(message).build());
        return endPoint;
    }

    @SqsListener("tax-spring-boot")
    public void loadMessagesFromQueue(String message) {
        System.out.println("Queue Messages" + message);
    }
}
