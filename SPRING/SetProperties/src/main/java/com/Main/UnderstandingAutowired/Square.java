package com.Main.UnderstandingAutowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure{
    private static final String name = "SQUARE";

    @Value("${square.sideL:1}")
    private double sideL;

    @Override
    public double calculateArea() {
        return sideL*sideL;
    }

    @Override
    public String getName() {
        return name;
    }
}
