package com.tr.pluralsight.repository;

import com.tr.pluralsight.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepositoryImpl implements CustomerRepository{

    public List<Customer> findAll() {

        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();

        customer.setFirstName("Tiago");
        customer.setLastName("Marques");

        customers.add(customer);

        return customers;
    }
}