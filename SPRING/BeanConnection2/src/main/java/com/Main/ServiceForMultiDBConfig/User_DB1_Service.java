package com.Main.ServiceForMultiDBConfig;

import com.Main.EntitysDB1.User;
import com.Main.RepositoryForMultiDBconfig.DB1_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class User_DB1_Service {

    @Autowired
    DB1_UserRepository db1_userRepository;

    public void addUser(){
        User user = new User();
        user.setName("Paul");
        user.setSurname("Manriquez");
        db1_userRepository.save(user);
        System.out.println("=== User saved in DB1 ===");
    }
}
