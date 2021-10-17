package com.bmarques.supplier.api.supplier;

import com.bmarques.supplier.domain.supplier.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private static final Logger log = LoggerFactory.getLogger(SupplierController.class);

    private final SupplierService service;
    private final SupplierMapper mapper;

    public SupplierController(SupplierService service, SupplierMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{state}")
    public SupplierResponse getSupplierByState(@PathVariable String state) {
        log.info("Received information request supplier by {}", state);
        return mapper.toResponse(service.getSupplierByState(state));
    }
}
