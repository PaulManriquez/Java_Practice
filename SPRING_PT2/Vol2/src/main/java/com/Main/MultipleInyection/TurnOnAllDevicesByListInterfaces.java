package com.Main.MultipleInyection;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnOnAllDevicesByListInterfaces {

    private List<TurnOnOFF> devicesTurnOnOFF;

    TurnOnAllDevicesByListInterfaces(List<TurnOnOFF> devicesTurnOnOFF){
        this.devicesTurnOnOFF = devicesTurnOnOFF;
        for(TurnOnOFF ptrT : devicesTurnOnOFF){
            ptrT.turnOnDevice();
        }
        System.out.println("==== DEVICES WHERE TURN ON ===");
        System.out.println(">IN TURNONALLDEVICES CONSTRUCTOR<");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("=== Before you go i will turn Off the devices ===");
        for(TurnOnOFF ptrONOFF : this.devicesTurnOnOFF){
            ptrONOFF.turnOffDevice();
        }
    }
}
