package com.Main.Manager;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Paul")
public class ProfileBeanExample {
    @PostConstruct
    public void init(){
        System.out.println("If you are seeing this is because the \n" +
                "development environment set this bean as available");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("Goodbye Paul");
    }
}
