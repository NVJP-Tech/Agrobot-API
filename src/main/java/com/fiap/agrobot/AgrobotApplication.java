package com.fiap.agrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AgrobotApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgrobotApplication.class, args);
	}
}
