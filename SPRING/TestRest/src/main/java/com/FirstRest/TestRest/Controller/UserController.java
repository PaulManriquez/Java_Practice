package com.FirstRest.TestRest.Controller;

import com.FirstRest.TestRest.Model.User;
import com.FirstRest.TestRest.MyCustomExceptions.UserNotFoundException;
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


    //==== PATH AND QUERY PARAMS EXAMPLE ===
//    @GetMapping
//    public ResponseEntity<List<User>> Users(){
//        return new ResponseEntity< List<User>>(userService.getUsers(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<User>> Users (
            @RequestParam(value="startwith",required=false)String startwith){
        return new ResponseEntity<List<User>>(userService.getUsers(startwith),HttpStatus.OK);
    }
    //==== PATH AND QUERY PARAMS EXAMPLE ===


    //Obtain user by searching its username
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


    @PutMapping(value="/{username}")
    public ResponseEntity<?> updateUser(
            @PathVariable("username") String username,
            @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(user, username);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("username") String username
    ){
        userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
