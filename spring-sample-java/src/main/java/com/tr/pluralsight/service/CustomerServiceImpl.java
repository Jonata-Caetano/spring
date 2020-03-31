 package com.tr.pluralsight.service;

import com.tr.pluralsight.model.Customer;
import com.tr.pluralsight.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)/*SCOPE_SINLESTON*/
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository/* = new HibernateCustomerRepositoryImpl()*/;

    public CustomerServiceImpl() {

    }

    //injection by constructor
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.println("We are using constructor injection");
        this.customerRepository = customerRepository;
    }

    //injection by setter
/*    @Autowired//--This is other option for injection
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("We are using setter injection");
        this.customerRepository = customerRepository;
    }*/

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
