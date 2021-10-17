package com.bmarques.springmockserver.controller;

import com.bmarques.springmockserver.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

  @Autowired
  private HelloWorldService service;

  @GetMapping
  public String getHelloWorld() {
    return service.getHelloWorld();
  }
}
