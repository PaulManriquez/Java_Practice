package com.Main.LoadProperties;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class showProperties {

    @Value("${mail.username}")
    private String username;

    public void showProperties(){
        System.out.println("=== LOAD OF PROPERTIES ===");
        System.out.println(username);
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("=== LOAD OF PROPERTIES ===");
        System.out.println(username);
    }
}
