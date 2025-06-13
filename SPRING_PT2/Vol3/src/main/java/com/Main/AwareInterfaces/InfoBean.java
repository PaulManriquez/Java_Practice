package com.Main.AwareInterfaces;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class InfoBean implements EnvironmentAware, BeanNameAware {

    private Environment environment;
    private String beanName;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setBeanName(String name) { //BeanName is set automatically as the class name
        this.beanName = name;
    }

    @PostConstruct
    public void printInfo() {
        // Accessing property from application.properties
        String appName = environment.getProperty("app.name");
        String appVersion = environment.getProperty("app.version");

        System.out.println("=== InfoBean ===");
        System.out.println("Bean name: " + beanName);
        System.out.println("App name: " + appName);
        System.out.println("App version: " + appVersion);
    }
}
