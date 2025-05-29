package com.Profiles;

import com.Profiles.MyProfiles.EnvironmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainProfiles {

	private static final Logger logger = LoggerFactory.getLogger(MainProfiles.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainProfiles.class, args);
		logger.info("Application started with profiles: {}", (Object) context.getEnvironment().getActiveProfiles());

		EnvironmentService envService = context.getBean(EnvironmentService.class);
		logger.info("Current Profile:{}",envService.getEnvironment());
	}
}
