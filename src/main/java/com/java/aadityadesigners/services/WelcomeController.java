package com.java.aadityadesigners.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    @GetMapping("/hello")
    public String helloWorld() {
      return "Hello, World!";
    }    
}
