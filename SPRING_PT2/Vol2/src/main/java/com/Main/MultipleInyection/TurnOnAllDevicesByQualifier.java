package com.Main.MultipleInyection;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TurnOnAllDevicesByQualifier {

    private TurnOnOFF cellphone;
    private TurnOnOFF Computer;

    @Autowired
    public void TurnOnAllDevicesByQualifier(
            @Qualifier("CELLPHONE-BEAN") TurnOnOFF cellphone,
            @Qualifier("COMPUTER-BEAN") TurnOnOFF computer
    ){
        this.cellphone = cellphone;
        this.Computer = computer;
    }

    @PostConstruct
    public void init(){
        System.out.println("===============================");
        System.out.println("The CELLPHONE and COMPUTER bean"
        + "\n where constructed by constructor");
    }
}
