

package com.tr.bluemoon.springdatajdbc.controller;

import com.tr.bluemoon.springdatajdbc.services.client.Client;
import com.tr.bluemoon.springdatajdbc.services.dependent.DependentService;
import com.tr.bluemoon.springdatajdbc.services.dependent.Dependent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dependent")
public class DependentController {

    @Autowired
    private DependentService dependentService;

    @GetMapping
    public List<Dependent> get() {
        List<Dependent> dependents = dependentService.getAll();
        return dependents;
    }

    @GetMapping("/{id}")
    public Optional<Dependent> getById(@PathVariable Integer id) {
        Optional<Dependent> dependents = dependentService.getById(id);
        return dependents;
    }

    @GetMapping("/client/{id}")
    public Optional<Client> getClientById(@PathVariable Integer id) {
        Optional<Client> dependent = dependentService.getClient(id);
        return dependent;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> add(@RequestBody @Valid Dependent dependent, UriComponentsBuilder uriBuilder) {
        dependentService.save(dependent);

        return ResponseEntity.ok("OK");
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> update(@RequestBody @Valid Dependent form, UriComponentsBuilder uriBuilder) {
        dependentService.update(form);

        return ResponseEntity.ok("OK");
    }
}
