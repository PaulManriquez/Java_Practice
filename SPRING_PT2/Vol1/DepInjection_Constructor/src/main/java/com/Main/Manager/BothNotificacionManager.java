package com.Main.Manager;


import com.Main.Interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BothNotificacionManager {

    private MessageService emailService;
    private MessageService smsService;

    @Autowired
    public BothNotificacionManager(
            @Qualifier("emailService")MessageService emailService,
            @Qualifier("SMSService")MessageService smsService
    ){
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void notify(String recipient, String message,boolean sms){
        if(sms){
            emailService.sendMessage(recipient,message);
        }else{
            emailService.sendMessage(recipient,message);
        }
    }

}
