package com.Scopes;


import com.Scopes.scope.ScopeExample;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainScopes {

	private static final Logger logger = LoggerFactory.getLogger(MainScopes.class);

	@Bean("firstName")
	public String getApplicationName(){
		return "Paul";
	}

	@Bean("lastName")
	public String getApplicationLastName(){
		return "Manriquez";
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MainScopes.class, args);

		ScopeExample SE1 = context.getBean(ScopeExample.class);
		ScopeExample SE2 = context.getBean(ScopeExample.class);

		logger.info("Service is a singleton by default");
		logger.info("Singleton by default? {}",SE1 ==SE2);

		String appName = context.getBean("firstName",String.class);
		logger.info("The app name is: {}",appName);

		String appLastName = context.getBean("lastName",String.class);
		logger.info("The app name is: {}",appLastName);

	}

}
