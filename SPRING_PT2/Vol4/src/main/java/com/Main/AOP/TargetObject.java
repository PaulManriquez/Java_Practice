package com.Main.AOP;

import org.springframework.stereotype.Component;

@Component
public class TargetObject {

    public void hello(String message){
        System.out.println("===== TargetObject helloMethod =====");
        System.out.println(message);
        System.out.println("====================================");
    }
}
