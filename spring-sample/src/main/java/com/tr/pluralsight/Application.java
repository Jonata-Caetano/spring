package com.tr.pluralsight;

import com.tr.pluralsight.service.CustomerService;
import com.tr.pluralsight.service.CustomerServiceImpl;

public class Application {
    public static void main(String[] args) {
        CustomerService service = new CustomerServiceImpl();

        System.out.println(service.findAll().get(0).getFirstName());
    }
}
