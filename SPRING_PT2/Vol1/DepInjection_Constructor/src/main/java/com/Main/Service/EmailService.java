package com.Main.Service;

import com.Main.Interfaces.MessageService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("emailService")
@Primary
public class EmailService implements MessageService {


    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}