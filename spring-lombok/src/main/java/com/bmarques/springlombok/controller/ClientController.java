package com.bmarques.springlombok.controller;

import com.bmarques.springlombok.model.Client;
import com.bmarques.springlombok.model.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/v1/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping
  public Mono<Client> getClient() {
    return Mono.fromCallable(clientService::getClient)
        .subscribeOn(Schedulers.boundedElastic());
  }
}
