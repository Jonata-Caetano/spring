
package com.tr.bluemoon.springdatajdbc.services.dependent;

import com.tr.bluemoon.springdatajdbc.services.client.Client;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DependentRepository extends CrudRepository<Dependent, Integer> {

    List<Dependent> findAll();

    @Query("select id, name from client where id = :id ")
    Optional<Client> findClientById(@Param("id") Integer id);

    Optional<Dependent> findById(Integer id);
}