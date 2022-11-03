package com.bmarques.springrabbitcloud.employee;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    @SneakyThrows
    public void getEmployee(final Message<EmployeeEvent> message) {
        log.info(message.getHeaders().toString());
        log.info("m=getEmployee, status=new, event={}", message.getPayload());
//        throw new RuntimeException("Apenas um teste de erro");
    }
}
