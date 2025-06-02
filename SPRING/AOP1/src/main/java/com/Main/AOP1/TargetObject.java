package com.Main.AOP1;

import org.springframework.stereotype.Component;

@Component
public class TargetObject {

    public void helloMessage(String name, int age){
        System.out.println("Saying hello from TargetObject");
    }

}
