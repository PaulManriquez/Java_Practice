package com.Main;


import com.Main.LifeCycle.ExplicitBean;
import com.Main.LifeCycle.LifeCycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	//Bean Explicit declaration / set init and destroy method
	//
//	@Bean(initMethod = "initM",destroyMethod = "destroyM")
//	public ExplicitBean getBean(){
//		return new ExplicitBean();
//	}


	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

		LifeCycleBean bean = context.getBean(LifeCycleBean.class);


		logger.info("SOMETHING");
	}

}
