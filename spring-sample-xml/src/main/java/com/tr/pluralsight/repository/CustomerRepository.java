package com.tr.pluralsight.repository;

import com.tr.pluralsight.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();
}
