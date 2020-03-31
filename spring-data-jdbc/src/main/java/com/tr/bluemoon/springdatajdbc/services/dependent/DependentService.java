package com.tr.bluemoon.springdatajdbc.services.dependent;

import com.tr.bluemoon.springdatajdbc.services.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependentService {

    @Autowired
    private DependentRepository dependentRepository;

    public List<Dependent> getAll() {
        return dependentRepository.findAll();
    }

    public Optional<Dependent> getById(Integer id) {
        return dependentRepository.findById(id);
    }

    public Optional<Client> getClient(Integer id) {
        return dependentRepository.findClientById(id);
    }
    public void save(Dependent dependent) {
        dependentRepository.save(dependent);
    }

    public void update(Dependent dependent) {
        if (dependent.getId() == null) {
            return;
        }

        if (!dependentRepository.existsById(dependent.getId())) {
            return;
        }

        dependentRepository.save(dependent);
    }

}