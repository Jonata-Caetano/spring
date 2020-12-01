package com.bmarques.springr2dbc.api;

import com.bmarques.springr2dbc.domain.Client;
import com.bmarques.springr2dbc.domain.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("client")
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;

  @GetMapping
  public Flux<Client> listAll() {
    return clientRepository.findAll();
  }

  @GetMapping("/{id}")
  public Mono<Client> findById(@PathVariable Integer id) {
    return clientRepository.findById(id)
        .doOnError(e -> System.out.println(e));
  }
}
