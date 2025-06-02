package com.FirstRest.TestRest.Controller;

import com.FirstRest.TestRest.Model.User;
import com.FirstRest.TestRest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> Users(){
        return new ResponseEntity< List<User>>(userService.getUsers(), HttpStatus.OK);
    }

    //Obtain user by searching its user name
    @GetMapping(value="/{username}")
    public ResponseEntity<User> userByUserName(
            @PathVariable("username")String username){
        return new ResponseEntity<User>(userService.obtainUserByUserName(username),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(
                userService.createUser(user),HttpStatus.CREATED
        );
    }
}
