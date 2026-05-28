package com.fiap.agrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // Adicione esse exclude
public class AgrobotApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgrobotApplication.class, args);
	}
}
