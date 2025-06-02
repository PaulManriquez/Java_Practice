package com.FirstRest.TestRest.Controller;

import com.FirstRest.TestRest.Model.User;
import com.FirstRest.TestRest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
