package com.inyeccion_by_attribute.inyectionByAttribute.Qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("PajaroClass")
public class Pajaro extends Animal implements Volador{

    private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

    public Pajaro(@Value("PajaroLoco") String nombre,@Value("72") Integer edad) {
        super(nombre, edad);
    }


    @Override
    public void volar() {
        log.info("Im a animal and im flaying mom");
    }
}
