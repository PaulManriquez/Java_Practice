package com.Main.Controller;

import com.Main.Entitys.User;
import com.Main.Repository.UserRepository;
import com.Main.Services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    //Return all the users
    @GetMapping
    public ResponseEntity<List<User>> displayUsers(){
        return new ResponseEntity<List<User>>(
                userService.getAllRoles(), HttpStatus.OK
        );
    }

    //PATHVARIABLE
    //Get a user by id or throw error
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId")Integer userId){
        return new ResponseEntity<User>(
                userService.getUserByID(userId),HttpStatus.OK
        );
    }

    //PATHVARIABLE
    //Get user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username")String username){
        return new ResponseEntity<User>(
                userService.UsergetByUsername(username),HttpStatus.OK
        );
    }

    //Get user by username and password
    @GetMapping("/username/{username}/{password}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username")String username,
                                                  @PathVariable("password")String password){
        return new ResponseEntity<User>(
                userService.UsergetByUsernameAndPassword(username,password),HttpStatus.OK
        );
    }

    //PATHPARAM
    //REQUESTBODY

}
