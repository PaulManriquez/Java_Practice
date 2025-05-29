package com.Main.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:areas.properties")
public class FigurePropertyConfiguration {

    @Bean //Its called : Explicit declaration
    public PropertySourcesPlaceholderConfigurer getPropertiesConfig(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
