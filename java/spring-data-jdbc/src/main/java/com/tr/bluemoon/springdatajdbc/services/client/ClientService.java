package com.tr.bluemoon.springdatajdbc.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public List<Client> getByName(String name) {
		return clientRepository.findByName(name).stream().collect(Collectors.toList());
	}

	public void save(Client client) {
		clientRepository.save(client);
	}

	public void update(Client client) {
		if(client.getId() == null) {
			return;
		}

		if(!clientRepository.existsById(client.getId())) {
			return;
		}

		clientRepository.save(client);
	}

}
