package com.Main.MultipleInyection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Order(3)
public class TurnOnAllDevicesByMap {


    private Map<String, TurnOnOFF> mapList;

    @Autowired
    public void TurnOnAllDevicesByMap(
           Map<String, TurnOnOFF> mapList
    ){
        System.out.println("===> ORDER 3 <===");
        this.mapList = mapList;

        for (Map.Entry<String, TurnOnOFF> entry : mapList.entrySet()) {
            String nombre = entry.getKey();
            TurnOnOFF device = entry.getValue();

            System.out.print("[" + nombre + "] -> ");
            device.turnOnDevice();  // Or any method defined in TurnOnOFF interface
        }
    }

}
