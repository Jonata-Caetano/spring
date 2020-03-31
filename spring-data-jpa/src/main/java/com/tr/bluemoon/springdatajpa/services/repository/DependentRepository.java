package com.tr.bluemoon.springdatajpa.services.repository;

import java.util.List;
import com.tr.bluemoon.springdatajpa.services.model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {

    List<Dependent> findByName(String name);
}