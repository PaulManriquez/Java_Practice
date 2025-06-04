package com.Main.ServiceForMultiDBConfig;

import com.Main.EntitysDB1.User;
import com.Main.RepositoryForMultiDBconfig2.DB2_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class User_DB2_Service {

    @Autowired
    DB2_UserRepository db1_userRepository;

    public void addUser(){
        User user = new User();
        user.setName("Paul");
        user.setSurname("Manriquez");
        db1_userRepository.save(user);
        System.out.println("=== User saved in DB1 ===");
    }
}
