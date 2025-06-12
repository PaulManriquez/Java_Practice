package com.Main.Service;

import com.Main.Interfaces.MessageService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service("SMSService")
public class SMSService implements MessageService {

    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("SMS sent to " + recipient + ": " + message);
    }

    @PostConstruct
    public void init(){
        System.out.println("Post construct SMS Message");
        System.out.println("This is implemented just after " +
                "the bean is instanced  and wired in the springboot context ");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Before the application context stop running, " +
                "you can set a logic to perform");
    }

}