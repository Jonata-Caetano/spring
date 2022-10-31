package com.bmarques.springarchunitmvcexample.domain.invoice;

import com.bmarques.springarchunitmvcexample.domain.customer.Customer;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Invoice {

    protected int id;
    protected LocalDate installment;

    protected Double value;

    protected Customer customer;
}
