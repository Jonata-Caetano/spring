package com.tr.bluemoon.springdatajpa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.tr.bluemoon.springdatajpa.services.DependentServices;
import com.tr.bluemoon.springdatajpa.services.model.Dependent;

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
@RequestMapping("/dependent")
public class DependentController {

    @Autowired
    private DependentServices dependentServices;

    @GetMapping
    public List<Dependent> getDependents() {
        return dependentServices.getDependents();
    }

    @PostMapping
    @TransactionScoped
    public ResponseEntity<Dependent> save(@RequestBody @Valid Dependent dependent, UriComponentsBuilder uriBuilder) {
        dependentServices.save(dependent);

        URI uri = uriBuilder.path("/dependent/{id}").buildAndExpand(dependent.getId()).toUri();
        return ResponseEntity.created(uri).body(dependent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dependent> getDependent(@PathVariable Integer id) {
        Optional<Dependent> dependent = dependentServices.getDependent(id);

        if (dependent.isPresent()) {
            return ResponseEntity.ok(dependent.get());
        }

        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Dependent> update(@PathVariable Integer id, @RequestBody @Valid Dependent dependent) {
        Optional<Dependent> optional = dependentServices.getDependent(id);

        if (optional.isPresent()) {
            Dependent dependentUpdate = dependentServices.update(id, dependent);
            return ResponseEntity.ok(dependentUpdate);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover (@PathVariable Integer id) {
        Optional<Dependent> optional = dependentServices.getDependent(id);

        if (optional.isPresent()) {
            dependentServices.delete(id);;
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}