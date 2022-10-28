package com.bmarques.springrabbitcloud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    public void getEmployee(final Message<EmployeeEvent> message) {
        log.info("m=getEmployee, status=new, event={}", message.getPayload());

//        try {
//            this.delete(message.getPayload());
//        } catch (final Exception e) {
//            log.error("m=delete, status=failed, event={}, headers={}, exception={}", message.getPayload(), message.getHeaders(), e.getMessage());
//            throw e;
//        }

    }
}
