package com.Main.Manager;

import com.Main.Interfaces.MessageService;
import org.springframework.stereotype.Component;

@Component
public class EnableToSetAny {

    private MessageService messageService;

    EnableToSetAny(){}

    public void setMessageService(MessageService messageService){
        this.messageService = messageService;
    }

    public void Notify(String recipient, String message){
        messageService.sendMessage(recipient, message);
    }
}
