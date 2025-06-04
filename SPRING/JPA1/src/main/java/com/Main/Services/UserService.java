package com.Main.Services;

import com.Main.Entitys.Role;
import com.Main.Entitys.User;
import com.Main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //Return all the users in the repo
    public List<User> getAllRoles(){
        return (List<User>) userRepository.findAll();
    }

    //Return the user found by id
    public User getUserByID(Integer id){
        return userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("The user with id:%d do not exist",id))
        );
    }

    public User UsergetByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("The user with name %s do not exist",username))
        );
    }

    public User UsergetByUsernameAndPassword(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("The user with name %s and pss:%s do not exist",username,password))
        );
    }
}
