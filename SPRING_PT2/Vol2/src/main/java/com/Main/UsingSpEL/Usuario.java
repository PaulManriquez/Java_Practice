package com.Main.UsingSpEL;

import org.springframework.stereotype.Component;

@Component
public class Usuario {

    public String getNombre() {
        return "Juan";
    }

    public Integer getAge(){
        return 19;
    }

    //They do not represent "stored" values —
    // they are just methods returning
    // constant literals.
}
