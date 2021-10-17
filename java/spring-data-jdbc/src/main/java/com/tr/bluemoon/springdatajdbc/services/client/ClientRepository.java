
package com.tr.bluemoon.springdatajdbc.services.client;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{

    List<Client> findAll();

    @Query("select id, name from client where upper(name) like '%' || upper(:name) || '%' ")
    List<Client> findByName(@Param("name") String name);
}