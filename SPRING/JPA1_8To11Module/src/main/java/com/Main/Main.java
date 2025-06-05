package com.Main;


import com.Main.Entitys.User;
import com.Main.Repository.UserRepository;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class Main implements ApplicationRunner {


	@Autowired
	private Faker faker;

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

	}

	@Override
	public void run(ApplicationArguments args)throws Exception{
		for(int i=0; i<30;i++){
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			user.setProfile(null);
			userRepository.save(user);
		}
	}
}
