package com.tr.bluemoon.springdatajpa;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringdatajpaApplication.class)
class SpringdatajpaApplicationTests {

	@ClassRule
	public static PostgreSQLContainer<BaeldungPostgresqlContainer> postgreSQLContainer = BaeldungPostgresqlContainer.getInstance();

	@Test
	void contextLoads() {
		System.out.println(postgreSQLContainer.getJdbcUrl());
	}

}
