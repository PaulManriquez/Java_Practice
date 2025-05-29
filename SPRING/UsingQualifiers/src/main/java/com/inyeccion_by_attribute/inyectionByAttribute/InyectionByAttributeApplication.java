package com.inyeccion_by_attribute.inyectionByAttribute;

import com.inyeccion_by_attribute.inyectionByAttribute.Attributes.Coche;
import com.inyeccion_by_attribute.inyectionByAttribute.Attributes.Motor;
import com.inyeccion_by_attribute.inyectionByAttribute.Qualifiers.Animal;
import com.inyeccion_by_attribute.inyectionByAttribute.Qualifiers.Nido;
import com.inyeccion_by_attribute.inyectionByAttribute.Qualifiers.Pajaro;
import com.inyeccion_by_attribute.inyectionByAttribute.Qualifiers.Perro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class InyectionByAttributeApplication {

	private static final Logger log = LoggerFactory.getLogger(InyectionByAttributeApplication.class);

	public static void main(String[] args) {

		//SpringApplication.run(InyectionByAttributeApplication.class, args);



		ConfigurableApplicationContext context = SpringApplication.run(InyectionByAttributeApplication.class, args);
		//Nido mynido = context.getBean(Nido.class);
		//mynido.imprimir();

		//Animal animal = context.getBean("MyDog",Animal.class);
		//log.info("Nombre:{} - Edad:{}",animal.getNombre(),animal.getEdad());

		Animal animal = context.getBean(Animal.class);
		log.info("Nombre:{} - Edad:{}",animal.getNombre(),animal.getEdad());

		//* Context is capturing the hole spring environment
		//* We get from the context the ben that we desire identified by MyDog tag
		//* We display its name extracted from the whole environment
	}


}



