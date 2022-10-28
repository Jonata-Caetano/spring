package com.bmarques.springrabbitcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private RabbitProducer rabbitProducer;

    @RequestMapping("/register")
    public void sendEmployeeEvent(@RequestBody EmployeeEvent employee) {
        rabbitProducer.sendEmployee(employee);
    }
}
