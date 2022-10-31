package com.bmarques.springarchunitmvcexample.domain.customer;

import com.bmarques.springarchunitmvcexample.domain.address.Street;
import lombok.Data;

@Data
public class Customer {

    private int id;
    private String name;
    //    VIOLATION RULE
//    private ElectronicInvoice invoice;
    private Street street;
}
