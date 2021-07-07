package com.bmarques.springfunction;

import com.bmarques.springfunction.invoice.InvoiceEntity;
import com.bmarques.springfunction.invoice.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class SpringFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFunctionApplication.class, args);
    }

    @Autowired
    private InvoiceService service;

    @Bean
    public Supplier<List<InvoiceEntity>> getInvoices() {
        return () -> service.getInvoices();
    }

}
