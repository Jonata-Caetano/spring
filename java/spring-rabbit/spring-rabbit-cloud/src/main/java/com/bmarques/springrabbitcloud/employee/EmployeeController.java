package com.bmarques.springrabbitcloud.employee;

import com.bmarques.springrabbitcloud.BindingDestinationProperties;
import com.bmarques.springrabbitcloud.RabbitProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final RabbitProducer<EmployeeRequest> rabbitProducer;
    private final BindingDestinationProperties properties;

    @PostMapping("/register")
    public void sendEmployeeEvent(@RequestBody EmployeeRequest employee) {
        rabbitProducer.sendMessage(properties.getEmployeeProducer(), employee);
    }
}
