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

		ConfigurableApplicationContext context = SpringApplication.run(InyectionByAttributeApplication.class, args);
		Coche coche = context.getBean(Coche.class);
		System.out.println(coche);
	}

}
