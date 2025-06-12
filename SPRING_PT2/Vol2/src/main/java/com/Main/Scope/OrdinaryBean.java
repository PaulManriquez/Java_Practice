package com.Main.Scope;

import org.springframework.stereotype.Component;

//NOTE: By default a regular bean is singleton
@Component
public class OrdinaryBean {

    public OrdinaryBean() {
        System.out.println("OrdinaryBean created: " + this);
    }

    public void action() {
        System.out.println("Using OrdinaryBean instance: " + this);
    }
}