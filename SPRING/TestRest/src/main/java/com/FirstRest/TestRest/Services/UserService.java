package com.FirstRest.TestRest.Services;

import com.FirstRest.TestRest.Model.User;
import com.FirstRest.TestRest.MyCustomExceptions.UserNotFoundException;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //==== PATH AND QUERY PARAMS EXAMPLE ===

//    public List<User> getUsers(){return users;}

    public List<User> getUsers(String startwith){
        if(startwith !=null){
            return users.stream().filter(u -> u.getUsername().startsWith(startwith)).collect(Collectors.toList());
        }else{
            return users;
        }
    }
    //==== PATH AND QUERY PARAMS EXAMPLE ===

    public User obtainUserByUserName(String username){
        return users.stream().filter(u -> u.getUsername().equals(username)).findAny()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("User %s not found",username)));
    }


    public User createUser(User user){
        if(users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    String.format("User %s already exist",user.getUsername()));
        }
        users.add(user);
        return user;
    }


    public User updateUser(User user,String username){
        User userToBeUpdated = obtainUserByUserName(username);

        if (userToBeUpdated == null) {
            throw new UserNotFoundException("User with username " + username + " not found");
        }else{
            userToBeUpdated.setNickName(user.getNickName());
            userToBeUpdated.setPassword(user.getPassword());
        }
        return userToBeUpdated;
    }

    public void deleteUser(String username){
        User userToDelete = obtainUserByUserName(username);
        users.remove(userToDelete);
    }

}
