package com.Main;


import com.Main.FullBeanLifeCycle.FullLifecycleBean2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public FullLifecycleBean2 fullLifecycleBean2() {
		return new FullLifecycleBean2();
	}


	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

		logger.info("SOMETHING");
	}

}
