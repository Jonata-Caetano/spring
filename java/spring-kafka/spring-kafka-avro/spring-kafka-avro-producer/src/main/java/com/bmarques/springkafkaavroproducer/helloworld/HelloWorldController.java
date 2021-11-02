package com.bmarques.springkafkaavroproducer.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @PostMapping
    public String getGreetings(@RequestBody String message) {
        return helloWorldService.getMessage(message);
    }
}
