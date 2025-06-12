package com.Main.Scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BeanMadePrototype {

    public BeanMadePrototype() {
        System.out.println("PrototypeBean created: " + this);
    }

    public void action() {
        System.out.println("Using PrototypeBean instance: " + this);
    }
}