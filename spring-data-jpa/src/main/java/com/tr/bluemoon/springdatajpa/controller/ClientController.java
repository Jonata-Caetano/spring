package com.tr.bluemoon.springdatajpa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.tr.bluemoon.springdatajpa.services.ClientServices;
import com.tr.bluemoon.springdatajpa.services.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @GetMapping
    public List<Client> getClients() {
        return clientServices.getClients();
    }

    @PostMapping
    @TransactionScoped
    public ResponseEntity<Client> save(@RequestBody @Valid Client client, UriComponentsBuilder uriBuilder) {
        clientServices.save(client);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Integer id) {
        Optional<Client> client = clientServices.getClient(id);

        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }

    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Client> update(@PathVariable Integer id, @RequestBody @Valid Client client) {
        Optional<Client> optional = clientServices.getClient(id);

        if (optional.isPresent()) {
            Client clientUpdate = clientServices.update(id, client);
            return ResponseEntity.ok(clientUpdate);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover (@PathVariable Integer id) {
        Optional<Client> optional = clientServices.getClient(id);

        if (optional.isPresent()) {
            clientServices.delete(id);;
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}