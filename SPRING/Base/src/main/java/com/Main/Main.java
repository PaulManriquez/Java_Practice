package com.Main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

		logger.info("SOMETHING");
	}

}
