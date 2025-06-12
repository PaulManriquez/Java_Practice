package com.Main;


import com.Main.Manager.BothNotificacionManager;
import com.Main.Manager.EnableToSetAny;
import com.Main.Manager.NotificationManager;
import com.Main.Service.EmailService;
import com.Main.Service.SMSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);


	//Not works for instances that are static  (main)
	//For that reason we cant inject into it
//	@Autowired
//	private SMSService smsService;

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

		NotificationManager notificationManager = context.getBean(NotificationManager.class);
		notificationManager.notify("MSG","This is my message");

		//Testing SETTER
		EnableToSetAny ETA = context.getBean(EnableToSetAny.class);
		EmailService ES = context.getBean(EmailService.class);

		ETA.setMessageService(ES);
		ETA.Notify("EMAIL SERVICE","Spring context");

		SMSService sms = context.getBean(SMSService.class);
		ETA.setMessageService(sms);
		ETA.Notify("SMS SERVICE","Spring context");


		logger.info("SOMETHING");
	}

}
