package com.Main.ExplicitDefinitionBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Car car() {
        return new Car("VOLKSWAGEN22");//Manually setting
    }//Bean injected by default in the application context as VOLKSWAGEN22
}
