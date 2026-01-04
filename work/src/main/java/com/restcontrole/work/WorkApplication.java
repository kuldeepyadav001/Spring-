package com.restcontrole.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WorkApplication {

	public static void main(String[] args) {

		SpringApplication.run(WorkApplication.class, args);
	}

	@Bean
	public PlatformTransactionManager trans(MongoDatabaseFactory dbfactory) {
		return new MongoTransactionManager(dbfactory);

	}
}
