package com.Main.MultipleInyection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CELLPHONE-BEAN")
@Order(1)
public class CellPHone implements TurnOnOFF {

    @Override
    public void turnOnDevice(){
        System.out.println("Turning On CELLPHONE");
    }

    @Override
    public void turnOffDevice(){
        System.out.println("Turning off CELLPHONE");
    }
}
