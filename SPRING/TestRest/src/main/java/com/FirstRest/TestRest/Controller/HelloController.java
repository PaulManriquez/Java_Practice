package com.FirstRest.TestRest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Stereotype (managed by springboot)
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String helloWorld(){
        return "Get from helloWorld() method";
    }
}
