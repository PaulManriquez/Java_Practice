package com.Main.Manager;

import com.Main.Interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {

    private final MessageService messageService;//Message service is an interface implemented by two beans

    // Constructor Injection (Spring auto-detects this)
    @Autowired//                    (*)
    public NotificationManager(
            @Qualifier("SMSService") MessageService messageService) {
        this.messageService = messageService;
    }

    public void notify(String recipient, String message) {
        messageService.sendMessage(recipient, message);
    }
}