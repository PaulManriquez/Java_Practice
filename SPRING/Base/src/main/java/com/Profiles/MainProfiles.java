package com.Profiles;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class MainProfiles {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MainProfiles.class, args);

	}

}
