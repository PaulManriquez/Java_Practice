package com.Main.ExplicitDefinitionBean;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private String modelCarName;

    public Car(String carname){
        this.modelCarName = carname;
        System.out.println("Carname:"+this.modelCarName);
    }

    public String getCarModel(){
        return this.modelCarName;
    }
}
