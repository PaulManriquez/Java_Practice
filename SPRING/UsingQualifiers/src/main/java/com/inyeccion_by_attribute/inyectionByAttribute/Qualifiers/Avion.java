package com.inyeccion_by_attribute.inyectionByAttribute.Qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Avion implements Volador {

    private static final Logger log = LoggerFactory.getLogger(Avion.class);

    @Override
    public void volar() {
    log.info("Im a Plane, and im flying mom");
    }
}
