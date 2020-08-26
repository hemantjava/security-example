package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityExample {


   // localhost:8181/encrypt/
    @GetMapping("/secure")
    public String message(){
        return "hello";
    }
}
