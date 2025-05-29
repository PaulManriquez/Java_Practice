package com.Main.UnderstandingAutowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure{
    private static final String name = "CIRCLE";

    @Value("3.78")
    private double radio;

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radio,2);
    }

    @Override
    public String getName() {
        return name;
    }
}
