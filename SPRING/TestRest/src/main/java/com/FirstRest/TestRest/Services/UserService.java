package com.FirstRest.TestRest.Services;

import com.FirstRest.TestRest.Model.User;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private Faker faker;

    private List<User> users= new ArrayList<>();

    @PostConstruct
    public void init(){

        for(int i=0;i<5;i++){
            users.add(
                    new User(faker.funnyName().name(),
                            faker.name().username(),
                            faker.dragonBall().character())
            );
        }
    }//END POSTCONSTRUCT INIT

    public List<User> getUsers(){return users;}
}
