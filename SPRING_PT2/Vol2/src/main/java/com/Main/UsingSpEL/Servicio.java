package com.Main.UsingSpEL;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Servicio {

    @Value("#{usuario.nombre}")
    private String nombreUsuario;

    @Value("#{usuario.age > 18 ? 'Adulto' : 'Menor'}")
    private String adultoMenor;

    @PreDestroy
    public void imprimir() {
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Este usuario es:"+adultoMenor);
    }

}