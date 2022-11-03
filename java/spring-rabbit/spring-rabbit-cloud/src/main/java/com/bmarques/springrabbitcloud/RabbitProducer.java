package com.bmarques.springrabbitcloud;

import com.bmarques.springrabbitcloud.employee.EmployeeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitProducer<T> {

    private final StreamBridge bridge;

    public void sendMessage(String properties, final T event) {
        log.info("m=sendMessage, event={}", event);
        this.bridge.send(properties, withPayload(event).build());
    }

}