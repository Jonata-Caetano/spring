package com.tr.bluemoon.springdatajpa.services;

import java.util.List;
import java.util.Optional;

import com.tr.bluemoon.springdatajpa.services.model.Client;
import com.tr.bluemoon.springdatajpa.services.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    public ClientServices(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(Integer id) {
        return clientRepository.findById(id);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Client update(Integer id, Client client) {

        Client clientUpdate = clientRepository.getOne(id);

        clientUpdate.setName(client.getName());
        clientRepository.save(clientUpdate);

        return clientUpdate;
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}