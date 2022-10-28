package com.bmarques.springrabbitcloud;

import java.util.function.Consumer;

import com.bmarques.springrabbitcloud.employee.EmployeeEvent;
import com.bmarques.springrabbitcloud.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeListener {

    private final EmployeeService employeeService;

    @Bean
    public Consumer<Message<EmployeeEvent>> sendEmployee() {
        return this.employeeService::getEmployee;
    }
}