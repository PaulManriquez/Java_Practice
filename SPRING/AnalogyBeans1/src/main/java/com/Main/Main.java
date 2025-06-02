package com.Main;


import com.Main.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class Main {

	@Autowired
	private OrderService orderService;

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

		OrderService orderService1 = context.getBean(OrderService.class);
		orderService1.placeOrder();
	}

}
