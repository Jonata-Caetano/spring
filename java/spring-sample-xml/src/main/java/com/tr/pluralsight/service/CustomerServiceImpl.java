package com.tr.pluralsight.service;

import com.tr.pluralsight.model.Customer;
import com.tr.pluralsight.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository/* = new HibernateCustomerRepositoryImpl() quem vai fazer isso será o Spring*/;

    public CustomerServiceImpl() {

    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    
    /*O responsável por executar esse código será o Spring */
    /*Este modelo de injeção é o Setter Injection */
    //public void setCustomerRepository(CustomerRepository customerRepository) {
    //    this.customerRepository = customerRepository;
    //}

}
