package com.tr.pluralsight.service;

import com.tr.pluralsight.model.Customer;
import com.tr.pluralsight.repository.CustomerRepository;
import com.tr.pluralsight.repository.HibernateCustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
