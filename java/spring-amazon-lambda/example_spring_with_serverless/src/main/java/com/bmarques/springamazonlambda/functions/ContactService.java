package com.bmarques.springamazonlambda.functions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContactService {

    public List<Contact> GetAllContacts(String s){
        log.info("Entrou aqui %s", s);
        Contact contact1 = Contact.builder()
                .id(1)
                .name("Tiago Marques")
                .address("Rua José Marcos Tomé")
                .build();

        Contact contact2 = Contact.builder()
                .id(1)
                .name("Roseli Marques")
                .address("Rua Estanislau Machinski")
                .build();

        return List.of(contact1, contact2);
    }
}
