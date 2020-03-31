package com.tr.pluralsight.service;

import com.tr.pluralsight.model.Customer;
import com.tr.pluralsight.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    //@Autowired //-- Este códogo esta comentado para que fosse explanado a outra forma de injeção
    private CustomerRepository customerRepository/* = new HibernateCustomerRepositoryImpl()resolvido com autowired*/;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        System.out.println("We are usgin constructor injection");
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    /*@Autowired //-- Injenção por setter
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("We are using setter injection");
        this.customerRepository = customerRepository;
    }*/
}
