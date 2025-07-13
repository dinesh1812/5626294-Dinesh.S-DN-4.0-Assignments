package com.cognizant.spring_learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    @ResponseBody
    public String greet(){
        return "Hello World! Im Dinesh";
    }
}
