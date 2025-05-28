package com.inyeccion_by_attribute.inyectionByAttribute;

import com.inyeccion_by_attribute.inyectionByAttribute.Attributes.Coche;
import com.inyeccion_by_attribute.inyectionByAttribute.Attributes.Motor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class InyectionByAttributeApplication {

	public static void main(String[] args) {

		//SpringApplication.run(InyectionByAttributeApplication.class, args);

		//=== Use the constructor to construct the new object
		//Motor is an independent object
		//Coche needs a motor to be a coche
		//Both are combinned and we get a new object
//		Motor motor= new Motor("Xl1",1981);
//		Coche coche = new Coche("VM",1986,motor);
//		System.out.println(coche);
		//===


		/*
		* You're starting the Spring Boot app, retrieving a Coche object from
		* the Spring context (because it's a @Component), and printing it using
		* toString(). The object is a Spring Bean, which means
		* it's fully managed by the Spring Framework —
		* including its dependencies like Motor.
		* */

		ConfigurableApplicationContext context = SpringApplication.run(InyectionByAttributeApplication.class, args);
		Coche coche = context.getBean(Coche.class);
		System.out.println(coche);
	}

}
//1
//Wich 'whole project will run' : InyectionByAttributeApplication.class

//2
//ApplicationContext = Read-only container (used to get beans, access environment, etc.)
//
//ConfigurableApplicationContext = Read-write container (lets you register, refresh, close, and customize the context)

//You use ConfigurableApplicationContext when you want more control over the application context, like:
//
//Manually closing the context
//
//Registering shutdown hooks
//
//Refreshing or restarting the context
//
//Adding custom bean definitions before the context refreshes
//
//Setting or overriding environment properties

//3
//Creating multiple contexts might make sense if:
//You're writing tests and need isolated environments.
//You're building a tool or plugin system with modular Spring applications loaded separately.
//You're working on a multi-tenant architecture where each tenant might need its own context (rare and advanced).
//
//Example:
//ConfigurableApplicationContext context1 = SpringApplication.run(AppConfig1.class);
//ConfigurableApplicationContext context2 = SpringApplication.run(AppConfig2.class);