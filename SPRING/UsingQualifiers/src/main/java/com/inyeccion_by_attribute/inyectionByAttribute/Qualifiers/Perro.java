package com.inyeccion_by_attribute.inyectionByAttribute.Qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("MyDog")
public class Perro extends Animal{
    public Perro(@Value("Rocky") String nombre,
                 @Value("2") Integer edad) {
        super(nombre, edad);
    }
}
