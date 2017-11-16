package com.site.jooqtest;

import model.LombokTest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JooqTestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JooqTestApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	}
}
