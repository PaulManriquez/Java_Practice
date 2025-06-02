package com.FirstRest.TestRest.Config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerBeanConfig {

    @Bean //Explicit inyection faker bean
    public Faker getFaker(){
        return new Faker();
    }
}
