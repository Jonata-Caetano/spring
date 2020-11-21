package com.bmarques.springlombok.model;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

  public Client getClient() {
    return new Client().builder()
        .code(1)
        .name("Tiago")
        .adress("Rua José Marcos Tomé")
        .phoneNumber("984824259")
        .build();
  }
}
