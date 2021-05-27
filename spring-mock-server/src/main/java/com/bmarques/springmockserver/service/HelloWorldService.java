package com.bmarques.springmockserver.service;

import java.net.URISyntaxException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloWorldService {

  private RestTemplate restTemplate;

  public HelloWorldService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public String getHelloWorld() throws URISyntaxException {
    String url = "http://localhost:1080/other/source";
    return this.restTemplate.getForObject(url, String.class);
  }
}
