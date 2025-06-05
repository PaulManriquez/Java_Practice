package com.Main.Controller;

import com.Main.Entitys.User;
import com.Main.Repository.UserRepository;
import com.Main.Services.UserService;

import io.micrometer.core.annotation.Timed;


import io.micrometer.core.instrument.Timer;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private io.micrometer.core.instrument.MeterRegistry meterRegistry;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @GetMapping("/testTimer")
    public String testTimer() {
        Timer.Sample sample = Timer.start(meterRegistry);
        try {
            Thread.sleep(300); // simulate work
        } catch (InterruptedException ignored) {}

        sample.stop(Timer.builder("test.manual.timer")
                .description("Manual test timer")
                .register(meterRegistry));

        return "ok";
    }


    //Return all the users
    @GetMapping
    public ResponseEntity<List<User>> displayUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //REQUESTPARAM      ?
    //Return the users by page

    @GetMapping("/getUsersByPage")
    @Timed(value = "get.users.page", description = "Time to get all users", histogram = true)
    @Operation(summary = "Get all users")
    public ResponseEntity<Page<User>> displayUsersPage(
            @RequestParam(required = false, value = "pageNumber", defaultValue="0") int pageNumber,
            @RequestParam(required = false, value = "pageSize", defaultValue="5") int pageSize){
        return new ResponseEntity<Page<User>>(
                  userService.getUsersPaginate(pageNumber,pageSize),HttpStatus.OK
        );
    }

    //PATHVARIABLE      /
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
    @GetMapping("/usernameAndPass/{username}/{password}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username")String username,
                                                  @PathVariable("password")String password){
        return new ResponseEntity<User>(
                userService.UsergetByUsernameAndPassword(username,password),HttpStatus.OK
        );
    }

    //Return all usernames
    @GetMapping("/DisplayUsersNames")
    public ResponseEntity<List<String>> displayUserNames(){
        return new ResponseEntity<List<String>>(
                userService.getAllUserNames(),HttpStatus.OK
        );
    }

    //Return all usernames Paginate
    @GetMapping("/DisplayUsersNamesPage")
    public ResponseEntity<Page<String>> displayUserNames(
            @RequestParam(required = false, value = "pageNumber", defaultValue="0") int pageNumber,
            @RequestParam(required = false, value = "pageSize", defaultValue="5") int pageSize
            ){
        return new ResponseEntity<Page<String>>(
                userService.getUsersNamesPaginate(pageNumber, pageSize),
                HttpStatus.OK
        );
    }



    //REQUESTBODY

}
