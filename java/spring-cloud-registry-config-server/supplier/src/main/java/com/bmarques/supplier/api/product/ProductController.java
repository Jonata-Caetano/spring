package com.bmarques.supplier.api.product;

import com.bmarques.supplier.domain.product.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    public ProductController(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{state}")
    public List<ProductResponse> getProductsByState(@PathVariable String state) {
        return service.getProductsByState(state)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
