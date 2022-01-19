package com.tr.bluemoon.springdatajpa.services.repository;

import java.util.List;
import com.tr.bluemoon.springdatajpa.services.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByName(String name);
}