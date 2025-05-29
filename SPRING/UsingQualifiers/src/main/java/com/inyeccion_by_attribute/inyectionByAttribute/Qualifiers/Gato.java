package com.inyeccion_by_attribute.inyectionByAttribute.Qualifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary  // ✅ This marks Gato as the default bean when injecting Animal
@Component
public class Gato extends Animal {
    public Gato(@Value("Michi") String nombre,
                @Value("3") Integer edad) {
        super(nombre, edad);
    }
}
