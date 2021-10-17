package com.bmarques.springamazonlambda.functions;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class ClientService implements Function<String, String> {

    @Autowired
    private ContactService contactService;

    @Override
    public String apply(String s) {
        return contactService.GetAllContacts(s).toString();
    }
}