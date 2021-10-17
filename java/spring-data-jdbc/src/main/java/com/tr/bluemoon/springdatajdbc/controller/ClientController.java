package com.tr.bluemoon.springdatajdbc.controller;

import java.util.List;

import javax.validation.Valid;

import com.tr.bluemoon.springdatajdbc.services.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tr.bluemoon.springdatajdbc.services.client.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @GetMapping
    public List<Client> get() {
        List<Client> clients = clientService.getAll();
        return clients;
    }

    @GetMapping("/{name}")
    public List<Client> getById(@PathVariable String name) {
        List<Client> clients = clientService.getByName(name);
        return clients;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> add(@RequestBody @Valid Client client, UriComponentsBuilder uriBuilder) {
        clientService.save(client);

        return ResponseEntity.ok("OK");
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> update(@RequestBody @Valid Client form, UriComponentsBuilder uriBuilder) {
        clientService.update(form);

        return ResponseEntity.ok("OK");
    } 
}
