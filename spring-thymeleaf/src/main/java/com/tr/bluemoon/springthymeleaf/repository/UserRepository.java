package com.tr.bluemoon.springthymeleaf.repository;

import com.tr.bluemoon.springthymeleaf.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Long> {

    List<Users> findAll();
}
