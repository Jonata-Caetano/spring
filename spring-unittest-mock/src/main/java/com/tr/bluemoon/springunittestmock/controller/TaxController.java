package com.tr.bluemoon.springunittestmock.controller;

import com.tr.bluemoon.springunittestmock.model.Tax;
import com.tr.bluemoon.springunittestmock.services.TaxServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.TransactionScoped;

@RestController
@RequestMapping("/tax")
@CrossOrigin
public class TaxController {

    @Autowired
    private TaxServices taxServices;

    /*@PostMapping
    @TransactionScoped
    public ResponseEntity<Tax> save(@RequestBody @Valid Client client, UriComponentsBuilder uriBuilder) {
        clientServices.save(client);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }*/

}
