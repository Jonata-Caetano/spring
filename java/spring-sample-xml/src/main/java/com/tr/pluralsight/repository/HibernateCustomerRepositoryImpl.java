package com.tr.pluralsight.repository;

import com.tr.pluralsight.model.Customer;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepositoryImpl implements CustomerRepository{

    @Value("${dbUsername}")
    private String dbUserName;

//    This is a way to inject a value
/*    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }*/

    public List<Customer> findAll() {
        System.out.println(dbUserName);

        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();

        customer.setFirstName("Tiago");
        customer.setLastName("Marques");

        customers.add(customer);

        return customers;
    }
}