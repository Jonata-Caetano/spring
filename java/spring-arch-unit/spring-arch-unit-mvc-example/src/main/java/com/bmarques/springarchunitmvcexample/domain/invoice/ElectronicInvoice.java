package com.bmarques.springarchunitmvcexample.domain.invoice;

import com.bmarques.springarchunitmvcexample.domain.customer.Customer;

import java.time.LocalDate;

public class ElectronicInvoice extends Invoice {

    ElectronicInvoice(int id, LocalDate installment, Double value, Customer customer) {
        super(id, installment, value, customer);
    }

    //    VIOLATION RULE
//    @Autowired
//    private ClientService clientService;
//
//    public String getFullName() {
//        return clientService.getName();
//    }
    public LocalDate getInstallment() {
        return installment;
    }
}
