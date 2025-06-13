package com.Main.MultipleInyection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Qualifier("COMPUTER-BEAN")
@Order(2)
public class Computer implements TurnOnOFF {
    @Override
    public void turnOnDevice(){
        System.out.println("Turning on COMPUTER");
    }

    @Override
    public void turnOffDevice(){
        System.out.println("Turning off COMPUTER");
    }
}
