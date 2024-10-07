package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
    @GetMapping("/")
    public String message(){
        return "Welcome to my website";
    }
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Helllo world";
    }
    
}
