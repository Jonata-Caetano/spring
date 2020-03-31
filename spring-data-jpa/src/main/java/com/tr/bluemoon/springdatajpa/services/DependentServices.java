package com.tr.bluemoon.springdatajpa.services;

import java.util.List;
import java.util.Optional;

import com.tr.bluemoon.springdatajpa.services.model.Dependent;
import com.tr.bluemoon.springdatajpa.services.repository.DependentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependentServices {

    @Autowired
    private DependentRepository dependentRepository;

    public DependentServices(DependentRepository dependentRepository) {
        this.dependentRepository = dependentRepository;
    }

    public List<Dependent> getDependents() {
        return dependentRepository.findAll();
    }

    public Optional<Dependent> getDependent(Integer id) {
        return dependentRepository.findById(id);
    }

    public void save(Dependent dependent) {
        dependentRepository.save(dependent);
    }

    public Dependent update(Integer id, Dependent dependent) {

        Dependent dependentUpdate = dependentRepository.getOne(id);

        dependentUpdate.setName(dependent.getName());
        dependentRepository.save(dependentUpdate);

        return dependentUpdate;
    }

    public void delete(Integer id) {
        dependentRepository.deleteById(id);
    }
}